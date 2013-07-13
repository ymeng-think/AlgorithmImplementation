package tw.ymeng.algorithm.interview.calculator.stack_calculator;

import org.junit.Test;
import tw.ymeng.algorithm.interview.calculator.CharTokenParser;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PostfixExpressionTest {

    @Test
    public void should_transform_infix_expression_that_only_contains_two_operands_to_postfix() {
        PostfixExpression postfixExpression = buildPostfix("1 + 2");

        assertThat(postfixExpression.transform(), is(new char[]{'1', '2', '+'}));
    }

    @Test
    public void should_transform_infix_expression_that_is_combined_with_addition_and_multiplication() {
        PostfixExpression postfixExpression = buildPostfix("1 + 2 * 3");

        assertThat(postfixExpression.transform(), is(new char[]{'1', '2', '3', '*', '+'}));
    }

    @Test
    public void should_transform_infix_expression_that_contains_brackets() {
        PostfixExpression postfixExpression = buildPostfix("1 + (3 - 2)");

        assertThat(postfixExpression.transform(), is(new char[]{'1', '3', '2', '-', '+'}));
    }

    @Test
    public void should_transform_infix_expression_that_contains_multi_operands_in_brackets() {
        PostfixExpression postfixExpression = buildPostfix("1 + (2 * 3 - 4)");

        assertThat(postfixExpression.transform(), is(new char[]{'1', '2', '3', '*', '4', '-', '+'}));
    }

    private PostfixExpression buildPostfix(String expression) {
        return new PostfixExpression(new CharTokenParser(expression).parse());
    }

}
