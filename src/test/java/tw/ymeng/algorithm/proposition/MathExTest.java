package tw.ymeng.algorithm.proposition;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static tw.ymeng.algorithm.proposition.MathEx.pow;

public class MathExTest {

    @Test
    public void should_get_power() {
        assertThat(pow(2L, 10), is(1024L));
    }
}
