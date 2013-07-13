package tw.ymeng.algorithm.interview.calculator.stack_calculator;

import tw.ymeng.algorithm.interview.calculator.CharTokenParser;

public class StackCalculator {

    private final char[] postfixTokens;

    public StackCalculator(String expression) {
        char[] tokens = new CharTokenParser(expression).parse();
        postfixTokens = new PostfixExpression(tokens).transform();
    }

    public int calculate() {
        return new PostfixExpressionCalculator(postfixTokens).calculate();
    }
}
