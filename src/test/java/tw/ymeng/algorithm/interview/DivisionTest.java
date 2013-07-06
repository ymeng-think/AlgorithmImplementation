package tw.ymeng.algorithm.interview;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DivisionTest {

    @Test
    public void should_implement_division_only_with_addition_and_substraction() {
        assertThat(Division.divide1(100, 3), is(33));
    }

    @Test
    public void should_implement_division_with_substraction_optimization_by_shift_operation() {
        assertThat(Division.divide2(100, 3), is(33));
    }

    @Test
    @Ignore
    public void should_implement_division_with_substraction_optimization_by_shift_operation_and_iteration() {
        assertThat(Division.divide2I(100, 3), is(33));
    }
}
