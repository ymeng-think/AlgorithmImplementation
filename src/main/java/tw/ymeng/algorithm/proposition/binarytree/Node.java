package tw.ymeng.algorithm.proposition.binarytree;

public class Node {
    private Node parent, leftChild, rightChild;
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public Node parent() {
        return parent;
    }

    public void parent(Node parent) {
        this.parent = parent;
    }

    public Node leftChild() {
        return leftChild;
    }

    public void leftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node rightChild() {
        return rightChild;
    }

    public void rightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public int data() {
        return data;
    }
}
