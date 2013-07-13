package tw.ymeng.algorithm.interview.calculator;

public class CharTokenParser {

    private final String expression;

    public CharTokenParser(String expression) {
        this.expression = expression;
    }

    public char[] parse() {
        String[] items = expression.split("\\s+");

        char[] tokens = new char[items.length];
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = items[i].charAt(0);
        }

        return tokens;
    }
}
