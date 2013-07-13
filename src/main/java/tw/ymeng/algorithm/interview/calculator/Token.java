package tw.ymeng.algorithm.interview.calculator;

public class Token {

    private final char token;

    public Token(char c) {
        this.token = c;
    }

    public boolean isDivisionSign() {
        return token == '/';
    }

    public boolean isProductSign() {
        return token == '*';
    }

    public boolean isMinusSign() {
        return token == '-';
    }

    public boolean isPlusSign() {
        return token == '+';
    }

    public boolean isDigit() {
        return token >= 48 && token <= 57;
    }
}
