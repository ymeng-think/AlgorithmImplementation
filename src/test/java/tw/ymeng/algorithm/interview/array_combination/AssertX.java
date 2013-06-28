package tw.ymeng.algorithm.interview.array_combination;

import static junit.framework.Assert.assertEquals;

public class AssertX {

    public static void assertIntArrayEquals(int[] expected, int[] actual) {
        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}
