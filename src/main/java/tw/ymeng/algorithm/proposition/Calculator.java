package tw.ymeng.algorithm.proposition;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final char[] tokens;
    private List<Object> sequence = new ArrayList<Object>();

    public Calculator(String expression) {
        this(breakToTokens(expression));
    }

    public Calculator(char[] tokens) {
        this.tokens = tokens;
    }

    public double calculate() {
        Double result = null;

        for (int i = 0; i < tokens.length; i++) {
            char token = tokens[i];

            if (isDigit(token)) {
                append(toDouble(token));
                continue;
            }

            if (isPlusSign(token) || isMinusSign(token)) {
                append(token);
                continue;
            }

            if (isProductSign(token) || isDivisionSign(token)) {
                if (result == null) {
                    result = (Double)popLast();
                }
                result = calculate(token, result, toDouble(tokens[++i]));
                append(result);
                result = null;
            }
        }

        if (result != null) {
            append(result);
        }

        result = (Double) sequence.get(0);
        for (int i = 1; i < sequence.size(); i += 2) {
            Character operator = (Character) sequence.get(i);
            Double other = (Double) sequence.get(i + 1);
            result = calculate(operator, result, other);
        }

        return result;
    }

    private static char[] breakToTokens(String expression) {
        String[] items = expression.split("\\s+");

        char[] tokens = new char[items.length];
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = items[i].charAt(0);
        }

        return tokens;
    }

    private Object popLast() {
        int lastIndex = sequence.size() - 1;
        Object last = sequence.get(lastIndex);
        sequence.remove(lastIndex);

        return last;
    }

    private void append(Object obj) {
        sequence.add(obj);
    }

    private boolean isDivisionSign(char token) {
        return token == '/';
    }

    private boolean isProductSign(char token) {
        return token == '*';
    }

    private boolean isMinusSign(char token) {
        return token == '-';
    }

    private boolean isPlusSign(char token) {
        return token == '+';
    }

    private boolean isDigit(char token) {
        return token >= 48 && token <= 57;
    }

    private double calculate(char token, double a, double b) {
        switch (token) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        throw new IllegalArgumentException("Illegal operator: " + token);
    }

    private double toDouble(char token) {
        return (int)token - 48;
    }

}
