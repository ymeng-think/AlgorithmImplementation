package tw.ymeng.algorithm.interview.explain_number_sequence;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExplainingNumberSequenceTest {

    @Test
    public void should_get_next_number_from_explaining_sequence() {
        ExplainingNumberSequence sequence = new ExplainingNumberSequence(1);

        sequence.next();

        assertThat(sequence.currentSeed(), is(11));
    }

    @Test
    public void should_get_following_number_from_explaining_sequence() {
        ExplainingNumberSequence sequence = new ExplainingNumberSequence(1);

        sequence.next().next().next().next().next();

        assertThat(sequence.currentSeed(), is(132112));
    }
}
