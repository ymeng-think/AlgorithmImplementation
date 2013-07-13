package tw.ymeng.algorithm.interview.calculator;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TreeCalculatorTest {

    @Test
    public void should_calculate_simple_addition() {
        TreeCalculator calculator = new TreeCalculator("1 + 2");

        assertThat(calculator.calculate(), is(3));
    }
}
