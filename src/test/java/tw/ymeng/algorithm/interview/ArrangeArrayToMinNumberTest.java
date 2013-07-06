package tw.ymeng.algorithm.interview;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ArrangeArrayToMinNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_array_is_null() {
        new ArrangeArrayToMinNumber(null);
    }

    @Test
    public void should_throw_exception_when_array_is_empty() {
        new ArrangeArrayToMinNumber(new int[0]);
    }

    @Test
    public void should_put_array_in_order_to_get_min_number() {
        ArrangeArrayToMinNumber array = new ArrangeArrayToMinNumber(new int[]{32, 321});

        assertThat(array.putInOrder(), is(32132));
    }
}
