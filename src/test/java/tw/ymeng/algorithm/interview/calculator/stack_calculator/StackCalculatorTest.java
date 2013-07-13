package tw.ymeng.algorithm.interview.calculator.stack_calculator;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StackCalculatorTest {

    @Test
    public void should_pass_case_1() {
        StackCalculator calculator = new StackCalculator("2 * 5 - 4 / 2");

        assertThat(calculator.calculate(), is(8));
    }

    @Test
    public void should_pass_case_2() {
        StackCalculator calculator = new StackCalculator("2 * (1 + 4 * 2) - 9 / 3");

        assertThat(calculator.calculate(), is(15));
    }
}
