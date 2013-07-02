package tw.ymeng.algorithm.proposition.binarytree;

import tw.ymeng.algorithm.proposition.binarytree.command.Insert;

public class Tree {

    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node insert(int data) {
        return new Insert(root, data).execute();
    }

}
