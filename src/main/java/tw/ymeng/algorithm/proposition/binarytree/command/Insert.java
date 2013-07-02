package tw.ymeng.algorithm.proposition.binarytree.command;

import tw.ymeng.algorithm.proposition.Command;
import tw.ymeng.algorithm.proposition.binarytree.Node;

public class Insert implements Command {

    private Node to;
    private int data;

    public Insert(Node to, int data) {
        this.to = to;
        this.data = data;
    }

    /**
     * Give a binary search tree and a number, inserts a new node with the given number in the
     * correct place in the tree.
     * @return the new root pointer which the caller should then use (the standard trick to avoid using reference parameters).
     * */
    @Override
    public Node execute() {
        return insert(to, data);
    }

    private static Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data <= node.data()) {
            node.leftChild(insert(node.leftChild(), data));
        } else {
            node.rightChild(insert(node.rightChild(), data));
        }
        return (node);
    }
}
