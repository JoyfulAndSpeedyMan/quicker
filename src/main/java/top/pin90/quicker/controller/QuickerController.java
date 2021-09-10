package top.pin90.quicker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import top.pin90.quicker.core.Analyzer;
import top.pin90.quicker.dto.quicker.QuickerResult;

@RestController
public class QuickerController {
    Mono<QuickerResult> EMPTY = Mono.just(new QuickerResult());

    final Analyzer analyzer;

    public QuickerController(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    public Mono<QuickerResult> quicker(String in){
        return EMPTY.publishOn(Schedulers.parallel())
                .map(e-> analyzer.analyzer(in));
    }
}
