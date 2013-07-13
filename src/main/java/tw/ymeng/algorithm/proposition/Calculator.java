package tw.ymeng.algorithm.proposition;

import java.util.Stack;

public class Calculator {

    private final char[] tokens;
    private Stack<Double> intermediateResult = new Stack<Double>();

    public Calculator(char[] tokens) {
        this.tokens = tokens;
    }

    public double calculate() {
        int index = 0;

        while (index < tokens.length) {
            char token = tokens[index++];

            if (isDigit(token)) {
                if (intermediateResult.empty()) {
                    intermediateResult.push(toDouble(token));
                }
            } else if (isOperator(token)) {
                double a = intermediateResult.pop();
                double b = toDouble(tokens[index++]);
                intermediateResult.push(calculate(token, a, b));
            }
        }

        return intermediateResult.pop();
    }

    private boolean isOperator(char token) {
        return token == '+' || token == '-' || token == '*' || token == '/';
    }

    private boolean isDigit(char token) {
        return token >= 48 && token <= 57;
    }

    private double calculate(char token, double a, double b) {
        switch (token) {
            case '+':
                return a + b;
        }
        throw new IllegalArgumentException("Illegal operator: " + token);
    }

    private double toDouble(char token) {
        return (int)token - 48;
    }

}
