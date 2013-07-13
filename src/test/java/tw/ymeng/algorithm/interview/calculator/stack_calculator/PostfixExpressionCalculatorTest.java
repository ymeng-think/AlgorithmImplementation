package tw.ymeng.algorithm.interview.calculator.stack_calculator;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PostfixExpressionCalculatorTest {

    @Test
    public void should_calculate_simple_postfix_expression() {
        PostfixExpressionCalculator calculator = new PostfixExpressionCalculator(new char[]{'1', '2', '+'});

        assertThat(calculator.calculate(), is(3));
    }

    @Test
    public void should_pop_operands_in_correct_order() {
        PostfixExpressionCalculator calculator = new PostfixExpressionCalculator(
                new char[]{'4', '2', '/'}
        );

        assertThat(calculator.calculate(), is(2));
    }

    @Test
    public void should_calculate_complicated_postfix_expression() {
        PostfixExpressionCalculator calculator = new PostfixExpressionCalculator(
                new char[]{'1', '2', '3', '*', '+', '4', '5', '*', '6', '+', '7', '*', '+'}
        );

        assertThat(calculator.calculate(), is(189));
    }
}
