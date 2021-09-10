package top.pin90.quicker;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.context.Context;

import java.util.LinkedList;

public class TestReactorContext {
    @Test
    public void t1(){
        String key = "message";
        Mono.subscriberContext()
                .map( ctx -> {
                    return "Hello " + ctx.get(key);
                })
                .subscriberContext( ctx -> {
                    Context world = ctx.put(key, "World");
                    return world;
                }) //订阅上下文,核心操作
                .subscribe(x -> {
                    System.out.println(x);
                });
    }

    @Test
    public void testContextBetweenFlatMap(){
        String key = "message";
        Mono.just("Hello")
                .flatMap( s -> Mono.subscriberContext()
                        .map( ctx -> s + " " + ctx.get(key)))
//                .subscriberContext(ctx -> ctx.put(key, "Reactor"))
                .flatMap( s -> Mono.subscriberContext()
                        .map( ctx -> s + " " + ctx.get(key)))
                .subscriberContext(ctx -> ctx.put(key, "World"))
                .subscribe(e-> System.out.println(e));

    }
}
