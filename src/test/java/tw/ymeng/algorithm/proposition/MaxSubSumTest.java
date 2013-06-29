package tw.ymeng.algorithm.proposition;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static tw.ymeng.algorithm.proposition.MaxSubSum.DivideAndConquerAlgorithm;
import static tw.ymeng.algorithm.proposition.MaxSubSum.LinearTimeAlgorithm;

public class MaxSubSumTest {

    private int[] array;
    private int maxSum;

    @Before
    public void setUp() {
        array = new int[]{4, -3, 5, -2, -1, 2, 6, -2};
        maxSum = 11;
    }

    @Test
    public void should_get_max_sub_sum_with_divide_and_conquer_algorithm() {
        assertThat(DivideAndConquerAlgorithm.maxSubSum(array), is(maxSum));
    }

    @Test
    public void should_get_max_sub_sum_with_linear_time_algorithm() {
        assertThat(LinearTimeAlgorithm.maxSubSum(array), is(maxSum));
    }
}
