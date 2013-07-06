package tw.ymeng.algorithm.proposition.histogram;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static tw.ymeng.algorithm.proposition.histogram.BitmapBuilder.O;
import static tw.ymeng.algorithm.proposition.histogram.BitmapBuilder.X;

public class BitmapBuilderTest {

    @Test
    public void should_build_bitmap() {
        boolean[][] bitmap = BitmapBuilder.build(2, new boolean[] {
                X, O,
                O, O
        });

        assertThat(bitmap.length, is(2));
        assertThat(bitmap[0], is(new boolean[]{true, false}));
        assertThat(bitmap[1], is(new boolean[]{true, true}));
    }
}
