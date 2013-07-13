package tw.ymeng.algorithm.interview.calculator;

public class TreeCalculator {

    private TreeNode root;

    public TreeCalculator(String expression) {
        char[] tokens = new CharTokenParser(expression).parse();
        this.root = new CalculationTreeGenerator(tokens).generate();
    }

    public int calculate() {
        return calculate(root);
    }

    private static int calculate(TreeNode node) {
        if (node.isLeaf()) {
            return convertToInt(node.data());
        }

        int a = calculate(node.leftChild());
        int b = calculate(node.rightChild());
        char operator = node.data();
        return calculate(operator, a, b);
    }

    private static int calculate(char operator, int op1, int op2) {
        switch (operator) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;
        }
        throw new IllegalArgumentException("Illegal operator: " + operator);
    }

    private static int convertToInt(char c) {
        return (int)c - 48;
    }

}
