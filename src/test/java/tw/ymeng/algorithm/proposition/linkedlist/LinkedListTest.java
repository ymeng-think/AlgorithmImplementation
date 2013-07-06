package tw.ymeng.algorithm.proposition.linkedlist;

import org.junit.Test;
import tw.ymeng.algorithm.proposition.linkedlist.command.FindNToLastNode;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static tw.ymeng.algorithm.proposition.linkedlist.LinkedListBuilder.build;
import static tw.ymeng.algorithm.proposition.linkedlist.command.LinkedListAsMatcher.as;

public class LinkedListTest {

    @Test
    public void should_return_true_if_circle_exists() {
        LinkedList linkedList = build(new int[]{1, 2, 3, 1});

        assertTrue(linkedList.hasCircle());
    }

    @Test
    public void should_get_circle_length() {
        LinkedList linkedList = build(new int[]{1, 2, 3, 1});

        assertThat(linkedList.getCircleLength(), is(3));
    }

    @Test
    public void should_reverse_linked_list() {
        LinkedList root = build(new int[]{1, 2, 3, 4});

        LinkedList reversed = root.reverse();

        assertThat(reversed, as(4, 3, 2, 1));
    }

    @Test
    public void should_find_n_to_last_node() {
        LinkedList linkedList = build(1, 2, 3, 4, 5, 6);
        FindNToLastNode command = new FindNToLastNode(linkedList, 3);

        int nodeData = command.execute();

        assertThat(nodeData, is(4));
    }
}
