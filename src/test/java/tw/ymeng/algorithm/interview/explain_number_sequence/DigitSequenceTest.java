package tw.ymeng.algorithm.interview.explain_number_sequence;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DigitSequenceTest {

    private DigitSequence sequence;

    @Before
    public void setUp() {
        sequence = new DigitSequence();
    }

    @Test
    public void should_get_digit_count() {
        sequence.add('1').add('1').add('2');

        assertThat(sequence.count('1'), is(2));
        assertThat(sequence.count('2'), is(1));
    }

    @Test
    public void should_convert_to_string() {
        sequence.add('1').add('2');

        assertThat(sequence.toString(), is("1112"));
    }

    @Test
    public void should_output_string_in_order_of_added_digits() {
        sequence.add('2').add('1');

        assertThat(sequence.toString(), is("1211"));
    }
}
