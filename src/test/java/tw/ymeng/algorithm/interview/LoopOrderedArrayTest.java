package tw.ymeng.algorithm.interview;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LoopOrderedArrayTest {

    private int[] array;

    @Before
    public void setUp() {
        array = new int[]{7, 8, 9, 0, 1, 2, 3, 4, 5, 6};
    }

    @Test
    public void should_find_target_in_loop_ordered_array() {
        LoopOrderedArray loopOrderedArray = new LoopOrderedArray(array);

        int index = loopOrderedArray.find(3);

        assertThat(index, is(6));
    }

    @Test
    public void should_return_negative_number_when_could_NOT_find_target() {
        LoopOrderedArray loopOrderedArray = new LoopOrderedArray(array);

        int index = loopOrderedArray.find(10);

        assertTrue(index < 0);
    }
}
