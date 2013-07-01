package tw.ymeng.algorithm.proposition.histogram;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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

        VerticalBitRectangle intersected = bitRectangle.merge(new boolean[]{O, O, O, O});

        assertThat(intersected.area(), is(4L));
    }

    @Test
    public void should_intersect_bit_rectangle_with_smaller_bit_array() {
        boolean[] bitArray = {X, O, O, X};
        VerticalBitRectangle bitRectangle = VerticalBitRectangle.convertFrom(bitArray);

        VerticalBitRectangle intersected = bitRectangle.merge(new boolean[]{X, O, X, X});

        assertThat(intersected.area(), is(2L));
    }

    @Test
    public void should_intersect_without_intersection_region() {
        boolean[] bitArray = {X, O, O, X};
        VerticalBitRectangle bitRectangle = VerticalBitRectangle.convertFrom(bitArray);

        VerticalBitRectangle intersected = bitRectangle.merge(new boolean[]{O, X, X, O});

        assertThat(intersected.area(), is(0L));
    }

}
