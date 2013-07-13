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

            if (stack.empty()) {
                stack.push(c);
                continue;
            }

            if (token.isRightBracket()) {
                clearStackUntilLatestLeftBracket(stack, postfixTokens);
                continue;
            }

            Token stackTop = new Token(stack.peek());
            if (token.comparePriority(stackTop) > 0 || stackTop.isLeftBracket()) {
                stack.push(c);
                continue;
            }

            postfixTokens.add(c);
        }

        while (!stack.empty()) {
            postfixTokens.add(stack.pop());
        }

        return convertToCharArray(postfixTokens);
    }

    private void clearStackUntilLatestLeftBracket(Stack<Character> stack, List<Character> postfixTokens) {
        Character token = stack.pop();
        while (token != '(') {
            postfixTokens.add(token);
            token = stack.pop();
        }
    }

    private char[] convertToCharArray(List<Character> list) {
        char[] array = new char[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}
