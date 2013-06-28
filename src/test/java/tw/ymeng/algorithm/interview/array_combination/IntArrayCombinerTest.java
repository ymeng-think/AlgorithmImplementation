package tw.ymeng.algorithm.interview.array_combination;

import org.junit.Test;

import static tw.ymeng.algorithm.interview.array_combination.AssertX.assertIntArrayEquals;

public class IntArrayCombinerTest {

    @Test
    public void should_combine_two_int_arrays_to_one_array_by_asc() {
        Combiner combiner = new Combiner();
        int[] array1 = {1, 3, 5, 7, 9};
        int[] array2 = {2, 4, 6, 8, 10};

        int [] array = combiner.combine(array1, array2);

        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertIntArrayEquals(expected, array);
    }

    @Test
    public void should_combine_two_int_arrays_to_one_array_by_desc() {
        Combiner combiner = new Combiner();
        int[] array1 = {9, 8, 6, 3, 2};
        int[] array2 = {7, 6, 3, 2};

        int [] array = combiner.combine(array1, array2);

        int[] expected = {9, 8, 7, 6, 6, 3, 3, 2, 2};
        assertIntArrayEquals(expected, array);
    }
}
