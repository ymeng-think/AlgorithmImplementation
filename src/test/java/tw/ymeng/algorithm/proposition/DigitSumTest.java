package tw.ymeng.algorithm.proposition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
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

    @Test
    public void should_find_a_couple_of_numbers_that_sum_is_specified_number_when_there_is_a_sorted_number_list() {
        DigitSum sum = new DigitSum(1, 2, 4, 7, 11, 15);

        int[] couple = sum.is(15);

        assertThat(couple.length, is(2));
        assertThat(couple[0], is(4));
        assertThat(couple[1], is(11));
    }

    @Test
    public void should_return_first_couple_when_there_are_multi_candidates_matched_request() {
        DigitSum sum = new DigitSum(1, 2, 3, 4, 7, 11, 12, 15);

        int[] couple = sum.is(15);

        assertThat(couple.length, is(2));
        assertThat(couple[0], is(3));
        assertThat(couple[1], is(12));
    }

    @Test
    public void should_find_a_couple_of_numbers_that_sum_is_specified_number_when_there_is_a_unsorted_number_list() {
        DigitSum sum = new DigitSum(1, 4, 2, 11, 15, 7);

        int[] couple = sum.is(15);

        assertThat(couple.length, is(2));
        assertThat(couple[0], is(4));
        assertThat(couple[1], is(11));
    }
}
