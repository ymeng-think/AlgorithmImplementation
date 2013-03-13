package tw.ymeng.algorithm.search;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

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
    public void should_return_negative_when_search_unexisted_item() {
        BinarySearch algorithm = new BinarySearch(sortedItems);

        assertEquals(-1, algorithm.search(10));
    }

    @Test
    public void should_return_index_when_find_low_boundary_of_an_existed_item() {
        BinarySearch algorithm = new BinarySearch(sortedItems);

        assertEquals(3, algorithm.searchPreItem(6));
    }
}
