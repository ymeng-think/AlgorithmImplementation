package tw.ymeng.algorithm.interview.calculator;

import java.util.ArrayList;
import java.util.List;

public class CharTokenParser {

    private final String expression;

    public CharTokenParser(String expression) {
        this.expression = expression;
    }

    public char[] parse() {
        List<Character> tokens = new ArrayList<Character>();

        for (char token : expression.toCharArray()) {
            if (isBlankChar(token)) {
                continue;
            }
            tokens.add(token);
        }

        return convertToCharArray(tokens);
    }

    private char[] convertToCharArray(List<Character> list) {
        char[] tokens = new char[list.size()];

        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = list.get(i);
        }

        return tokens;
    }

    private boolean isBlankChar(char c) {
        return c == '\t' || c == ' ';
    }
}
