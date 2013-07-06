package tw.ymeng.algorithm.interview;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DivisionTest {

    @Test
    public void should_implement_division_only_with_addition_and_substraction() {
        assertThat(Division.divide(6, 3), is(2));
    }
}
