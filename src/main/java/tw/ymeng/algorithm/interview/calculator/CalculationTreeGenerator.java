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

    private int getPriority(char c) {
        Token token = new Token(c);

        if (token.isDigit()) {
            return 3;
        }
        if (token.isProductSign() || token.isDivisionSign()) {
            return 2;
        }
        if (token.isPlusSign() || token.isMinusSign()) {
            return 1;
        }
        throw new IllegalArgumentException("Unknown token: " + c);
    }

}
