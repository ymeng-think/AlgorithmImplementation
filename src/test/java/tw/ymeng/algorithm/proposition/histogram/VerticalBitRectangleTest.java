package tw.ymeng.algorithm.proposition.histogram;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static tw.ymeng.algorithm.proposition.histogram.BitmapBuilder.O;
import static tw.ymeng.algorithm.proposition.histogram.BitmapBuilder.X;

public class VerticalBitRectangleTest {

    @Test
    public void should_get_area_of_bit_rectangle() {
        VerticalBitRectangle bitRectangle = new VerticalBitRectangle(0, 2, 3);

        assertThat(bitRectangle.area(), is(6L));
    }

    @Test
    public void should_build_vertical_bit_rectangle_object_with_bit_array() {
        boolean[] bitArray = {X, O, O, X};

        VerticalBitRectangle bitRectangle = VerticalBitRectangle.convertFrom(bitArray);

        assertThat(bitRectangle.area(), is(2L));
    }

    @Test
    public void should_intersect_bit_rectangle_with_larger_bit_array() {
        boolean[] bitArray = {X, O, O, X};
        VerticalBitRectangle bitRectangle = VerticalBitRectangle.convertFrom(bitArray);

        VerticalBitRectangle intersected = bitRectangle.intersect(new boolean[]{O, O, O, O});

        assertThat(intersected.area(), is(4L));
    }

    @Test
    public void should_intersect_bit_rectangle_with_smaller_bit_array() {
        boolean[] bitArray = {X, O, O, O, X};
        VerticalBitRectangle bitRectangle = VerticalBitRectangle.convertFrom(bitArray);

        VerticalBitRectangle intersected = bitRectangle.intersect(new boolean[]{X, O, X, X, X});

        assertThat(intersected.area(), is(2L));
    }

    @Test
    public void should_intersect_without_intersection_region() {
        boolean[] bitArray = {X, O, O, X};
        VerticalBitRectangle bitRectangle = VerticalBitRectangle.convertFrom(bitArray);

        VerticalBitRectangle intersected = bitRectangle.intersect(new boolean[]{O, X, X, O});

        assertThat(intersected.area(), is(0L));
    }

    @Test
    public void should_compare_area_size() {
        VerticalBitRectangle bitRectangle1 = VerticalBitRectangle.convertFrom(new boolean[]{O, O, O, X});
        VerticalBitRectangle bitRectangle2 = VerticalBitRectangle.convertFrom(new boolean[]{X, O, O, X});

        assertTrue(bitRectangle1.isLargerThan(bitRectangle2));
    }

    @Test
    public void should_intersect_bit_rectangles_even_though_they_have_no_intersection() {
        VerticalBitRectangle bitRectangle1 = new VerticalBitRectangle(0, 2, 2);
        VerticalBitRectangle bitRectangle2 = new VerticalBitRectangle(2, 2, 2);

        VerticalBitRectangle intersected = bitRectangle1.intersect(bitRectangle2);

        assertThat(intersected.area(), is(0L));
    }

    @Test
    public void should_intersect_bit_rectangles_that_has_same_region() {
        VerticalBitRectangle bitRectangle1 = new VerticalBitRectangle(1, 2, 2);
        VerticalBitRectangle bitRectangle2 = new VerticalBitRectangle(1, 2, 2);

        VerticalBitRectangle intersected = bitRectangle1.intersect(bitRectangle2);

        assertThat(intersected.area(), is(8L));
    }

    @Test
    public void should_intersect_bit_rectangle_with_the_other_which_is_smaller() {
        VerticalBitRectangle bitRectangle1 = new VerticalBitRectangle(0, 2, 4);
        VerticalBitRectangle bitRectangle2 = new VerticalBitRectangle(1, 2, 2);

        VerticalBitRectangle intersected = bitRectangle1.intersect(bitRectangle2);

        assertThat(intersected.area(), is(8L));
    }

    @Test
    public void should_build_a_bit_rectangle_as_place_holder() {
        assertThat(VerticalBitRectangle.holder(5).area(), is(0L));
    }

    @Test
    public void should_intersect_holder_with_bit_array_that_start_with_1() {
        VerticalBitRectangle holder = VerticalBitRectangle.holder(3);

        VerticalBitRectangle intersected = holder.intersect(new boolean[]{O, X, X});

        assertThat(intersected.area(), is(1L));
    }

    @Test
    public void should_intersect_holder_with_bit_array_that_start_with_0() {
        VerticalBitRectangle holder = VerticalBitRectangle.holder(3);

        VerticalBitRectangle intersected = holder.intersect(new boolean[]{X, X, O});

        assertThat(intersected.area(), is(1L));
    }

}
