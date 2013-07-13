package tw.ymeng.algorithm.proposition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void should_calculate_simple_addition() {
        Calculator calculator = new Calculator(new char[]{'1', '+', '1'});

        assertThat(calculator.calculate(), is(2.0));
    }
}
