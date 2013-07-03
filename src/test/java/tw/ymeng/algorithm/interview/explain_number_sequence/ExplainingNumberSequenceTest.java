package tw.ymeng.algorithm.interview.explain_number_sequence;

import org.junit.Test;
import tw.ymeng.algorithm.interview.explain_number_sequence.ExplainingNumberSequence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExplainingNumberSequenceTest {

    @Test
    public void should_get_next_number_from_explaining_sequence() {
        ExplainingNumberSequence sequence = new ExplainingNumberSequence(1);

        assertThat(sequence.next(), is(11));
    }
}
