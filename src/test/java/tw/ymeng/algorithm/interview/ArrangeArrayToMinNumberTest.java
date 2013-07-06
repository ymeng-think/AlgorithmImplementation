package tw.ymeng.algorithm.interview;

import org.junit.Test;

public class ArrangeArrayToMinNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_array_is_null() {
        new ArrangeArrayToMinNumber(null);
    }

    @Test
    public void should_throw_exception_when_array_is_empty() {
        new ArrangeArrayToMinNumber(new int[0]);
    }
}
