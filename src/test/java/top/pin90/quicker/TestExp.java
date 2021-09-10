package top.pin90.quicker;

import org.junit.jupiter.api.Test;
import top.pin90.quicker.complexExpression.Expression;

public class TestExp {
    @Test
    public void t(){
        String s = "xhstrhsfcv1`31@";
        Expression expr = new Expression(s);
        System.out.println(expr.value().val);
    }
}
