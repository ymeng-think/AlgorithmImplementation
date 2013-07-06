package tw.ymeng.algorithm.proposition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static tw.ymeng.algorithm.proposition.GreatestCommonFactor.gcd;

public class GreatestCommonFactorTest {

    @Test
    public void should_get_greatest_common_factor() {
        assertThat(gcd(50, 15), is(5));
    }
}
