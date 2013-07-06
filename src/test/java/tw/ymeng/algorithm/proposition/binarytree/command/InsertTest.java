package tw.ymeng.algorithm.proposition.binarytree.command;

import org.junit.Test;
import tw.ymeng.algorithm.proposition.binarytree.Node;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InsertTest {

    @Test
    public void should_insert_new_node_to_empty_tree() {

        Node root = new Insert(null, 1).execute();

        assertThat(root.data(), is(1));
    }

    @Test
    public void should_insert_node_as_left_child() {
        Node root = new Node(2);

        root = new Insert(root, 1).execute();

        assertThat(root.leftChild().data(), is(1));
    }

    @Test
    public void should_insert_node_as_right_child() {
        Node root = new Node(2);

        root = new Insert(root, 3).execute();

        assertThat(root.rightChild().data(), is(3));
    }
}
