package tw.ymeng.algorithm.interview.calculator.stack_calculator.operation;

public final class Operations {

    public static BinaryOperator create(char operatorChar) {
        switch (operatorChar) {
            case '+':
                return new Addition();
            case '-':
                return new Subtraction();
            case '*':
                return new Multiplication();
            case '/':
                return new Division();
        }
        throw new IllegalArgumentException("Illegal operator: " + operatorChar);
    }

    private Operations() {
    }
}
