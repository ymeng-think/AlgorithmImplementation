package tw.ymeng.algorithm.interview.calculator.stack_calculator;

import tw.ymeng.algorithm.interview.calculator.Token;
import tw.ymeng.algorithm.interview.calculator.stack_calculator.operation.Operations;

import java.util.Stack;

class PostfixExpressionCalculator {

    private final char[] postfixTokens;

    public PostfixExpressionCalculator(char[] postfixTokens) {
        this.postfixTokens = postfixTokens;
    }

    public int calculate() {
        Stack<Integer> stack = new Stack<Integer>();

        for (char c : postfixTokens) {
            Token token = new Token(c);
            if (token.isDigit()) {
                stack.push(toInt(c));
                continue;
            }

            int op2 = stack.pop();
            int op1 = stack.pop();
            stack.push(calculate(c, op1, op2));
        }

        return stack.pop();
    }

    private int calculate(char operator, int a, int b) {
        return Operations.create(operator).execute(a, b);
    }

    private static Integer toInt(char c) {
        return (int)c - 48;
    }
}
