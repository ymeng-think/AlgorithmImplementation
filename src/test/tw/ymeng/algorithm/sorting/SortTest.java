package tw.ymeng.algorithm.sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {

    private int[] unsorted;
    private int[] expected;

    @Before
    public void setUp() {
        unsorted = new int[]{5, 9, 1, 4, 8, 2, 6, 3, 7};
        expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Test
    public void should_sort_with_straight_insertion_sort() {
        int[] actual = StraightInsertionSort.sort(unsorted);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void should_sort_with_shell_sort() {
        int[] actual = ShellSort.sort(unsorted);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void should_sort_with_select_sort() {
        int[] actual = SelectSort.sort(unsorted);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void should_sort_with_heap_sort() {
        int[] actual = HeapSort.sort(unsorted);

        assertArrayEquals(expected, actual);
    }
}
