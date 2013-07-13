package tw.ymeng.algorithm.interview.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Question (expression evaluation)
 *
 * Please write code to evaluate an abstract expression contains:interger, '+', '-', '*', '/'.
 * If you could process '('and ')' then will be a plus. We have some test cases for '(' and ')', try to pass them.
 * If you can use object-oriented code to write the code then will be a big plus.
 *
 * Note: Please also write some test cases and include them in the comments of your code.It will be a plus.
 * Note: Don't call system commands or any shell script to calculate the expressions, we will check your code logic.
 * Note: You can refer the code sample below for the input/output

 Example1
 input: 2 * 5 - 4 / 2
 output: 8

 Example2
 input: 2 * (1 + 4 * 2) - 9 / 3
 output: 15
 * */
public class Calculator {

    private final char[] tokens;
    private List<Object> sequence = new ArrayList<Object>();

    public Calculator(String expression) {
        this(new CharTokenParser(expression).parse());
    }

    public Calculator(char[] tokens) {
        this.tokens = tokens;
    }

    public double calculate() {
        for (int i = 0; i < tokens.length; i++) {
            Token token = new Token(tokens[i]);

            if (token.isDigit()) {
                append(toDouble(tokens[i]));
                continue;
            }

            if (token.isPlusSign() || token.isMinusSign()) {
                append(tokens[i]);
                continue;
            }

            if (token.isProductSign() || token.isDivisionSign()) {
                Double result = (Double)popLast();
                result = calculate(tokens[i], result, toDouble(tokens[i + 1]));
                i++;
                append(result);
            }
        }

        Double result = (Double) sequence.get(0);
        for (int i = 1; i < sequence.size(); i += 2) {
            Character operator = (Character) sequence.get(i);
            Double other = (Double) sequence.get(i + 1);
            result = calculate(operator, result, other);
        }

        return result;
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

    private static double calculate(char token, double a, double b) {
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

    private static double toDouble(char token) {
        return (int)token - 48;
    }

}
