package tw.ymeng.algorithm.sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {

    private int[] unsorted;
    private int[] expected;

    @Before
    public void setUp() {
        unsorted = new int[]{6, 7, 4, 2, 10};
        expected = new int[]{2, 4, 6, 7, 10};
    }

    @Test
    public void should_sort_by_straight_insertion_sort() {
        StraightInsertionSort algorithm = new StraightInsertionSort();

        int[] actual = algorithm.sort(unsorted);

        assertArrayEquals(expected, actual);
    }
}
