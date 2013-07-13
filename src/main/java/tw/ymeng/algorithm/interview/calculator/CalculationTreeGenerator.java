package tw.ymeng.algorithm.interview.calculator;

class CalculationTreeGenerator {

    private final char[] tokens;
    private TreeNode root;

    public CalculationTreeGenerator(char[] tokens) {
        this.tokens = tokens;
    }

    public TreeNode generate() {
        root = new TreeNode(tokens[0]);

        for (int i = 1; i < tokens.length; i++) {
            char token = tokens[i];

            if (isLowerPriority(token)) {
                TreeNode newNode = new TreeNode(token);
                TreeNode temp = root;
                root = newNode;
                newNode.leftChild(temp);
            } else {
                root.rightChild(new TreeNode(token));
            }
        }

        return root;
    }

    private boolean isLowerPriority(char token) {
        int tokenPriority = getPriority(token);
        int rootPriority = getPriority(root.data());
        return tokenPriority < rootPriority;
    }

    private int getPriority(char token) {
        if (isDigit(token)) {
            return 3;
        }
        if (isProductSign(token) || isDivisionSign(token)) {
            return 2;
        }
        if (isPlusSign(token) || isMinusSign(token)) {
            return 1;
        }
        throw new IllegalArgumentException("Unknown token: " + token);
    }

    private static boolean isDivisionSign(char token) {
        return token == '/';
    }

    private static boolean isProductSign(char token) {
        return token == '*';
    }

    private static boolean isMinusSign(char token) {
        return token == '-';
    }

    private static boolean isPlusSign(char token) {
        return token == '+';
    }

    private static boolean isDigit(char token) {
        return token >= 48 && token <= 57;
    }
}
