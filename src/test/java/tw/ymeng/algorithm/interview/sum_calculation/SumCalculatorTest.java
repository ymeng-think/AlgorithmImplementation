package tw.ymeng.algorithm.interview.sum_calculation;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SumCalculatorTest {

    @Test
    public void should_sum_sequence_array() {
        Sequence seq1 = new Sequence(1, 1);
        Sequence seq2 = new Sequence(1, 2);

        SumCalculator caculator = new SumCalculator();
        int result = caculator.sum(seq1, seq2);

        assertEquals(12, result);
    }

    @Test
    public void should_sum_sequence_array_2() {
        Sequence seq1 = new Sequence(2, 1);
        Sequence seq2 = new Sequence(2, 2);
        Sequence seq3 = new Sequence(2, 3);

        SumCalculator caculator = new SumCalculator();
        int result = caculator.sum(seq1, seq2, seq3);

        assertEquals(246, result);
    }
}
