package tw.ymeng.algorithm.interview.sum_calculation;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SequenceArrayParserTest {

    @Test
    public void should_parse() {
        String text = "2 3";

        Sequence[] array = SequenceArrayParser.parse(text);

        assertEquals(2, array[0].value());
        assertEquals(4, array[1].value());
        assertEquals(6, array[2].value());
    }
}
