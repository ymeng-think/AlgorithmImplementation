package tw.ymeng.algorithm.interview.calculator.stack_calculator;

import tw.ymeng.algorithm.interview.calculator.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class PostfixExpression {

    private final char[] tokens;

    public PostfixExpression(char[] tokens) {
        this.tokens = tokens;
    }

    public char[] transform() {
        Stack<Character> stack = new Stack<Character>();
        List<Character> postfixTokens = new ArrayList<Character>();

        for (char c : tokens) {
            Token token = new Token(c);
            if (token.isDigit()) {
                postfixTokens.add(c);
                continue;
            }

            if (token.isOperator()) {
                if (stack.empty() || token.comparePriority(new Token(stack.peek())) > 0) {
                    stack.push(c);
                } else {
                    postfixTokens.add(c);
                }
            }
        }

        while (!stack.empty()) {
            postfixTokens.add(stack.pop());
        }

        return convertToCharArray(postfixTokens);
    }

    private char[] convertToCharArray(List<Character> list) {
        char[] array = new char[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}
