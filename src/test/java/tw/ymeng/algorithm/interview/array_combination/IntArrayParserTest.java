package tw.ymeng.algorithm.interview.array_combination;

import org.junit.Test;

import static tw.ymeng.algorithm.interview.array_combination.AssertX.assertIntArrayEquals;

public class IntArrayParserTest {

    @Test
    public void should_parse_text_to_int_array() {
        IntArrayParser parser = new IntArrayParser();
        String text = "1 2  3";

        int[] array = parser.parse(text);

        int[] expected = {1, 2, 3};
        assertIntArrayEquals(expected, array);
    }
}
