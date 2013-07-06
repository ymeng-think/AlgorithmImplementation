package tw.ymeng.algorithm.proposition.histogram;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static tw.ymeng.algorithm.proposition.histogram.BitmapBuilder.*;

public class BitmapScannerTest {

    @Test
    public void should_get_max_area_when_there_is_only_one_bit() {
        BitmapScanner bitmapScanner = new BitmapScanner(build(1, new boolean[]{
                O
        }));

        VerticalBitRectangle rectangle = bitmapScanner.getMaxRectangle();

        assertThat(rectangle.area(), is(1L));
    }

    @Test
    public void should_get_max_area_when_no_gaps_between_rectangles() {
        BitmapScanner bitmapScanner = new BitmapScanner(build(2, new boolean[]{
                O, O
        }));

        VerticalBitRectangle rectangle = bitmapScanner.getMaxRectangle();

        assertThat(rectangle.area(), is(2L));
    }

    @Test
    public void should_get_max_area_when_rectangles_are_arranged_as_ladder() {
        BitmapScanner bitmapScanner = new BitmapScanner(build(3, new boolean[]{
                X, X, O,
                X, O, O,
                O, O, O
        }));

        VerticalBitRectangle rectangle = bitmapScanner.getMaxRectangle();

        assertThat(rectangle.area(), is(4L));
    }

    @Test
    public void should_get_max_area_when_rectangles_are_arranged_as_mirrored_ladder() {
        BitmapScanner bitmapScanner = new BitmapScanner(build(3, new boolean[]{
                O, X, X,
                O, O, X,
                O, O, O
        }));

        VerticalBitRectangle rectangle = bitmapScanner.getMaxRectangle();

        assertThat(rectangle.area(), is(4L));
    }

    @Test
    public void should_get_max_area_when_rectangles_are_arranged_as_reversed_ladder() {
        BitmapScanner bitmapScanner = new BitmapScanner(build(3, new boolean[]{
                O, O, O,
                X, O, O,
                X, X, O
        }));

        VerticalBitRectangle rectangle = bitmapScanner.getMaxRectangle();

        assertThat(rectangle.area(), is(4L));
    }

    @Test
    public void should_get_max_area_when_rectangles_are_arranged_as_mirrored_and_reversed_ladder() {
        BitmapScanner bitmapScanner = new BitmapScanner(build(3, new boolean[]{
                O, O, O,
                O, O, X,
                O, X, X
        }));

        VerticalBitRectangle rectangle = bitmapScanner.getMaxRectangle();

        assertThat(rectangle.area(), is(4L));
    }

    @Test
    public void should_get_max_area_when_rectangles_are_arranged_as_pyramid() {
        BitmapScanner bitmapScanner = new BitmapScanner(build(5, new boolean[]{
                X, X, O, X, X,
                X, O, O, O, X,
                O, O, O, O, O,
        }));

        VerticalBitRectangle rectangle = bitmapScanner.getMaxRectangle();

        assertThat(rectangle.area(), is(6L));
    }

    @Test
    public void should_get_max_area_when_rectangles_are_arranged_as_reversed_pyramid() {
        BitmapScanner bitmapScanner = new BitmapScanner(build(5, new boolean[]{
                O, O, O, O, O,
                X, O, O, O, X,
                X, X, O, X, X,
        }));

        VerticalBitRectangle rectangle = bitmapScanner.getMaxRectangle();

        assertThat(rectangle.area(), is(6L));
    }

    @Test
    public void should_get_max_area_when_rectangles_are_arranged_as_wall() {
        BitmapScanner bitmapScanner = new BitmapScanner(build(3, new boolean[]{
                O, O, O,
                O, O, O,
                O, O, O,
        }));

        VerticalBitRectangle rectangle = bitmapScanner.getMaxRectangle();

        assertThat(rectangle.area(), is(9L));
    }

    @Test
    public void should_get_max_area_when_there_are_no_rectangles() {
        BitmapScanner bitmapScanner = new BitmapScanner(build(3, new boolean[]{
                X, X, X,
                X, X, X,
                X, X, X,
        }));

        VerticalBitRectangle rectangle = bitmapScanner.getMaxRectangle();

        assertThat(rectangle.area(), is(0L));
    }
}
