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
        int enteredBrackets = 0;

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
                enteredBrackets--;
                continue;
            }

            if (token.isLeftBracket()) {
                enteredBrackets++;
            }

            Token stackTop = new Token(stack.peek());

            if (stackTop.isLeftBracket()) {
                stack.push(c);
                continue;
            }

            if (token.comparePriority(stackTop) <= 0) {
                if (enteredBrackets > 0) {
                    postfixTokens.add(stack.pop());
                } else {
                    popStackUntilLowerPriorityOperator(stack, postfixTokens, c);
                }
            }
            
            stack.push(c);
        }

        while (!stack.empty()) {
            postfixTokens.add(stack.pop());
        }

        return convertToCharArray(postfixTokens);
    }

    private void popStackUntilLowerPriorityOperator(Stack<Character> stack, List<Character> postfixTokens, char c) {
        while (!stack.empty() && Token.comparePriority(stack.peek(), c) >= 0) {
            postfixTokens.add(stack.pop());
        }
    }

    private void clearStackUntilLatestLeftBracket(Stack<Character> stack, List<Character> postfixTokens) {
        char token = stack.pop();
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
