package tw.ymeng.algorithm.proposition.linkedlist.command;

import org.junit.Test;
import tw.ymeng.algorithm.proposition.linkedlist.LinkedList;

import static org.junit.Assert.assertThat;
import static tw.ymeng.algorithm.proposition.linkedlist.LinkedListBuilder.build;
import static tw.ymeng.algorithm.proposition.linkedlist.command.LinkedListAsMatcher.as;

public class ReverseTest {

    @Test
    public void should_reverse_linked_list() {
        LinkedList root = build(new int[]{1, 2, 3, 4});

        LinkedList reversed = root.reverse();

        assertThat(reversed, as(4, 3, 2, 1));
    }
}
