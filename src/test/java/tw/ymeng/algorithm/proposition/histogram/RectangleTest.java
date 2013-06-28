package tw.ymeng.algorithm.proposition.histogram;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

public class RectangleTest {

    @Test
    public void should_get_area_of_rectangle() {
        Rectangle rect = new Rectangle(2, 3);

        assertThat(rect.area(), is(6L));
    }

    @Test
    public void should_compare_area_of_rectangles() {
        Rectangle rect1 = new Rectangle(2, 3);
        Rectangle rect2 = new Rectangle(2, 2);

        assertThat(rect1.area(), greaterThan(rect2.area()));
    }
}
