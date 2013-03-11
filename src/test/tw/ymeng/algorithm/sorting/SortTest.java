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
        Sort algorithm = new StraightInsertionSort(unsorted);

        assertArrayEquals(expected, algorithm.sort());
    }

    @Test
    public void should_sort_with_shell_sort() {
        Sort algorithm = new ShellSort(unsorted);

        assertArrayEquals(expected, algorithm.sort());
    }

    @Test
    public void should_sort_with_select_sort() {
        Sort algorithm = new SelectSort(unsorted);

        assertArrayEquals(expected, algorithm.sort());
    }

    @Test
    public void should_sort_with_heap_sort() {
        Sort algorithm = new HeapSort(unsorted);

        assertArrayEquals(expected, algorithm.sort());
    }

    @Test
    public void should_sort_with_bubble_sort() {
        Sort algorithm = new BubbleSort(unsorted);

        assertArrayEquals(expected, algorithm.sort());
    }
}
