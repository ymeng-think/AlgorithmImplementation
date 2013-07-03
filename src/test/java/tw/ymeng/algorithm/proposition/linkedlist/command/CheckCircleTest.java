package tw.ymeng.algorithm.proposition.linkedlist.command;

import org.junit.Test;
import tw.ymeng.algorithm.proposition.linkedlist.LinkedList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static tw.ymeng.algorithm.proposition.linkedlist.LinkedListBuilder.build;

public class CheckCircleTest {

    @Test
    public void should_return_true_if_circle_exists() {
        LinkedList root = build(1, 2, 3, 1);

        assertTrue(new CheckCircle(root).execute());
    }

    @Test
    public void should_return_false_if_circle_exists() {
        LinkedList root = build(1, 2, 3);

        assertFalse(new CheckCircle(root).execute());
    }
}
