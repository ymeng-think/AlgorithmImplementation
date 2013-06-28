package tw.ymeng.algorithm.proposition.histogram;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BitmapScannerTest {

    @Test
    public void should_get_max_area_when_there_is_only_one_bit() {
        boolean[][] bitmap = new boolean[1][];
        bitmap[0] = new boolean[]{true};
        BitmapScanner bitmapScanner = new BitmapScanner(bitmap);

        Rectangle rectangle = bitmapScanner.getMaxRectangle();

        assertThat(rectangle.width(), is(1));
        assertThat(rectangle.height(), is(1));
    }

    @Test
    public void should_get_max_area_when_no_gaps_between_rectangles() {
        boolean[][] bitmap = new boolean[2][];
        bitmap[0] = new boolean[]{true};
        bitmap[1] = new boolean[]{true};
        BitmapScanner bitmapScanner = new BitmapScanner(bitmap);

        Rectangle rectangle = bitmapScanner.getMaxRectangle();

        assertThat(rectangle.width(), is(2));
        assertThat(rectangle.height(), is(1));
    }

    @Test
    public void should_get_max_area_when_rectangles_are_arranged_as_ladder() {
        boolean[][] bitmap = new boolean[3][];
        bitmap[0] = new boolean[]{true, false, false};
        bitmap[1] = new boolean[]{true, true,  false};
        bitmap[2] = new boolean[]{true, true,  true };

        BitmapScanner bitmapScanner = new BitmapScanner(bitmap);

        Rectangle rectangle = bitmapScanner.getMaxRectangle();

        assertThat(rectangle.width(), is(2));
        assertThat(rectangle.height(), is(2));
    }


    @Test
    public void should_get_max_area_that_first_meet_when_rectangles_are_arranged_as_ladder() {
        boolean[][] bitmap = new boolean[2][];
        bitmap[0] = new boolean[]{true, false};
        bitmap[1] = new boolean[]{true, true };

        BitmapScanner bitmapScanner = new BitmapScanner(bitmap);

        Rectangle rectangle = bitmapScanner.getMaxRectangle();

        assertThat(rectangle.width(), is(2));
        assertThat(rectangle.height(), is(1));
    }

    @Test
    @Ignore
    public void should_get_max_area_when_rectangles_are_arranged_as_pyramid() {
        boolean[][] bitmap = new boolean[3][];
        bitmap[0] = new boolean[]{true, false};
        bitmap[1] = new boolean[]{true, true };
        bitmap[2] = new boolean[]{true, false};

        BitmapScanner bitmapScanner = new BitmapScanner(bitmap);

        Rectangle rectangle = bitmapScanner.getMaxRectangle();

        assertThat(rectangle.width(), is(1));
        assertThat(rectangle.height(), is(2));
    }
}
