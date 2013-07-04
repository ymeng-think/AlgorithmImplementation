package tw.ymeng.algorithm.proposition.linkedlist.command;

import org.junit.Ignore;
import org.junit.Test;
import tw.ymeng.algorithm.proposition.linkedlist.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static tw.ymeng.algorithm.proposition.linkedlist.LinkedListBuilder.build;

public class FindNToLastNodeTest {

    @Test
    public void should_find_n_to_last_node() {
        LinkedList linkedList = build(1, 2, 3, 4, 5, 6);
        FindNToLastNode command = new FindNToLastNode(linkedList, 3);

        int nodeData = command.execute();

        assertThat(nodeData, is(4));
    }

    @Test
    public void should_find_last_node() {
        LinkedList linkedList = build(1, 2);
        FindNToLastNode command = new FindNToLastNode(linkedList, 1);

        int nodeData = command.execute();

        assertThat(nodeData, is(2));
    }

    @Test
    public void should_find_node_when_there_is_only_a_node_in_lined_list() {
        LinkedList linkedList = build(1);
        FindNToLastNode command = new FindNToLastNode(linkedList, 1);

        int nodeData = command.execute();

        assertThat(nodeData, is(1));
    }

    @Test
    public void should_find_first_node() {
        LinkedList linkedList = build(1, 2);
        FindNToLastNode command = new FindNToLastNode(linkedList, 2);

        int nodeData = command.execute();

        assertThat(nodeData, is(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_n_is_larger_than_length_of_linked_list() {
        LinkedList linkedList = build(1, 2);
        FindNToLastNode command = new FindNToLastNode(linkedList, 3);

        command.execute();
    }
}
