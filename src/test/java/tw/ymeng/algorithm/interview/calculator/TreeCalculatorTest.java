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

    @Test
    public void should_calculate_simple_subtraction() {
        TreeCalculator calculator = new TreeCalculator("2 - 1");

        assertThat(calculator.calculate(), is(1));
    }

    @Test
    public void should_calculate_simple_multiplication() {
        TreeCalculator calculator = new TreeCalculator("1 * 2");

        assertThat(calculator.calculate(), is(2));
    }

    @Test
    public void should_calculate_simple_division() {
        TreeCalculator calculator = new TreeCalculator("4 / 2");

        assertThat(calculator.calculate(), is(2));
    }
}
