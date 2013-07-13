package tw.ymeng.algorithm.interview.calculator;

public class TreeNode {
    private TreeNode parent, leftChild, rightChild;
    private char data;

    public TreeNode(char data) {
        this.data = data;
    }

    public TreeNode parent() {
        return parent;
    }

    public TreeNode leftChild() {
        return leftChild;
    }

    public void leftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
        leftChild.parent = this;
    }

    public TreeNode rightChild() {
        return rightChild;
    }

    public void rightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
        rightChild.parent = this;
    }

    public char data() {
        return data;
    }

    public boolean isLeaf() {
        return leftChild() == null && rightChild() == null;
    }
}
