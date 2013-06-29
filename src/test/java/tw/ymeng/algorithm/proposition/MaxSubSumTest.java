package tw.ymeng.algorithm.proposition;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static tw.ymeng.algorithm.proposition.MaxSubSum.maxSubSum;

public class MaxSubSumTest {

    @Test
    public void should_get_max_sub_sum_that_is_from_left_part() {
        int[] array = {4, 0, 5, 0, 0, -2, 0, 0};

        assertThat(maxSubSum(array), is(9));
    }

    @Test
    public void should_get_max_sub_sum_that_is_from_right_part() {
        int[] array = {0, 0, -2, 0, 0, 5, 0, 4};

        assertThat(maxSubSum(array), is(9));
    }

    @Test
    public void shoudl_get_max_sub_sum_that_is_from_center_region() {
        int[] array = {4, -3, 5, -2, -1, 2, 6, -2};

        assertThat(maxSubSum(array), is(11));
    }
}
