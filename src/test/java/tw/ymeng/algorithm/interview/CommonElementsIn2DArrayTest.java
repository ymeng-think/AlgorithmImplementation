package tw.ymeng.algorithm.interview;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CommonElementsIn2DArrayTest {

    private CommonElementsIn2DArray finder;

    @Before
    public void setUp() {
        finder = new CommonElementsIn2DArray();
    }

    @Test
    public void should_find_common_elements() {
        int[][] arrays = new int[2][];
        arrays[0] = new int[] {1, 2, 3};
        arrays[1] = new int[] {3, 4, 5};

        int[] result = finder.findCommonElements(arrays);

        assertThat(result, is(new int[]{3}));
    }

    @Test
    public void should_NOT_find_any_common_elements() {
        int[][] arrays = new int[2][];
        arrays[0] = new int[] {1, 2, 3};
        arrays[1] = new int[] {4, 5, 6};

        int[] result = finder.findCommonElements(arrays);

        assertThat(result.length, is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_array_is_null() {
        finder.findCommonElements(null);
    }

}
