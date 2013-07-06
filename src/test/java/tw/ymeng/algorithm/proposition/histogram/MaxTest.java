package tw.ymeng.algorithm.proposition.histogram;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void should_find_max_in_integer_array() {
        int[] array = {2, 5, 1, 12, 0, 4};

        assertThat(Max.max(array), is(12));
    }
}
