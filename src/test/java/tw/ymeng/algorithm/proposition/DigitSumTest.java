package tw.ymeng.algorithm.proposition;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class DigitSumTest {

    @Test
    public void should_find_a_couple_of_numbers_that_sum_is_specified_number_when_there_are_only_two_numbers_in_list() {
        DigitSum sum = new DigitSum(4, 11);

        int[] couple = sum.is(15);

        assertThat(couple.length, is(2));
        assertThat(couple[0], is(4));
        assertThat(couple[1], is(11));
    }

    @Test
    public void should_return_null_array_when_can_NOT_find_a_couple_of_numbers_that__is_specified_number() {
        DigitSum sum = new DigitSum(4, 11);

        int[] couple = sum.is(14);

        assertThat(couple, sameInstance(DigitSum.NULL));
    }
}
