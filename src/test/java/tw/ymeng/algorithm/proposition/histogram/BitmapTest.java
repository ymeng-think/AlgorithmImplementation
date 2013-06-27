package tw.ymeng.algorithm.proposition.histogram;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static tw.ymeng.algorithm.proposition.histogram.Bitmap.bitmap;

public class BitmapTest {

    @Test
    public void should_build_default_bitmap() {
        boolean[][] bitmap = bitmap(2, 1).build();

        assertThat(bitmap[0][0], is(false));
        assertThat(bitmap[1][0], is(false));
    }

    @Test
    public void should_build_bitmap_with_init_value() {
        boolean[][] bitmap = bitmap(2, 2).with(2, 1).build();

        assertThat(bitmap[0][0], is(true));
        assertThat(bitmap[0][1], is(true));
        assertThat(bitmap[1][0], is(true));
        assertThat(bitmap[1][1], is(false));
    }
}
