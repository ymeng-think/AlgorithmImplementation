package tw.ymeng.algorithm.search;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class BinarySearchTest {

    private int[] sortedItems;

    @Before
    public void setUp() {
        sortedItems = new int[]{1, 2, 3, 5, 7, 8, 9};
    }

    @Test
    public void should_return_index_when_search_an_existed_item() {
        BinarySearch algorithm = new BinarySearch(sortedItems);

        assertEquals(3, algorithm.search(5));
    }

    @Test
    public void should_return_negative_when_search_UNEXISTED_item() {
        BinarySearch algorithm = new BinarySearch(sortedItems);

        assertTrue(algorithm.search(10) < 0);
    }

    @Test
    public void should_return_index_when_find_previous_item() {
        BinarySearch algorithm = new BinarySearch(sortedItems);

        assertEquals(3, algorithm.searchPrevItem(6));
    }

    @Test
    public void should_return_negative_when_do_NOT_exist_previous_item() {
        BinarySearch algorithm = new BinarySearch(sortedItems);

        assertTrue(algorithm.searchPrevItem(0) < 0);
    }

    @Test
    public void should_return_index_when_find_next_item() {
        BinarySearch algorithm = new BinarySearch(sortedItems);

        assertEquals(4, algorithm.searchNextItem(6));
    }

    @Test
    public void should_return_negative_when_do_NOT_exist_next_item() {
        BinarySearch algorithm = new BinarySearch(sortedItems);

        assertTrue(algorithm.searchNextItem(10) < 0);
    }
}
