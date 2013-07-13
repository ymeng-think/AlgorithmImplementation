package tw.ymeng.algorithm.interview.calculator;

public class Token {

    private final char data;

    public Token(char c) {
        this.data = c;
    }

    public boolean isDivisionSign() {
        return data == '/';
    }

    public boolean isProductSign() {
        return data == '*';
    }

    public boolean isMinusSign() {
        return data == '-';
    }

    public boolean isPlusSign() {
        return data == '+';
    }

    public boolean isDigit() {
        return data >= 48 && data <= 57;
    }

    public boolean isOperator() {
        return isPlusSign() || isMinusSign() || isProductSign() || isDivisionSign();
    }

    public int comparePriority(Token token) {
        return getPriority(data) - getPriority(token.data);
    }

    private static int getPriority(char c) {
        switch (c) {
            case '*':
                return 2;
            case '/':
                return 2;
            case '+':
                return 1;
            case '-':
                return 1;
        }
        throw new IllegalArgumentException("Unknown operator: " + c);
    }
}
