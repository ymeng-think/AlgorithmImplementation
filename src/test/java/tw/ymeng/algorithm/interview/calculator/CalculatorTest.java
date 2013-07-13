package tw.ymeng.algorithm.interview.calculator;

import org.junit.Test;
import tw.ymeng.algorithm.interview.calculator.Calculator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void should_calculate_simple_addition() {
        Calculator calculator = new Calculator(new char[]{'1', '+', '1'});

        assertThat(calculator.calculate(), is(2.0));
    }

    @Test
    public void should_calculate_simple_subtraction() {
        Calculator calculator = new Calculator(new char[]{'1', '-', '1'});

        assertThat(calculator.calculate(), is(0.0));
    }

    @Test
    public void should_calculate_simple_multiplication() {
        Calculator calculator = new Calculator(new char[]{'1', '*', '2'});

        assertThat(calculator.calculate(), is(2.0));
    }

    @Test
    public void should_calculate_simple_division() {
        Calculator calculator = new Calculator(new char[]{'1', '/', '2'});

        assertThat(calculator.calculate(), is(0.5));
    }

    @Test
    public void should_calculate_composition_of_addition_and_subtraction() {
        Calculator calculator = new Calculator(new char[]{'1', '+', '2', '-', '3'});

        assertThat(calculator.calculate(), is(0.0));
    }

    @Test
    public void should_calculate_composition_of_addition_and_multiplication() {
        Calculator calculator = new Calculator(new char[]{'1', '+', '2', '*', '3'});

        assertThat(calculator.calculate(), is(7.0));
    }

    @Test
    public void should_pass_case_1() {
        Calculator calculator = new Calculator("2 * 5 - 4 / 2");

        assertThat(calculator.calculate(), is(8.0));
    }
}
