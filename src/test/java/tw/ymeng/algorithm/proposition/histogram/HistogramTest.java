package tw.ymeng.algorithm.proposition.histogram;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HistogramTest {

    @Test
    public void should_get_max_area_when_there_is_only_one_in_histogram_list() {
        Histogram histograms = new Histogram(2);

        int area = histograms.getMaxArea();

        assertThat(area, is(2));
    }

    @Test
    @Ignore
    public void should_get_max_area() {
        Histogram histograms = new Histogram(2, 1, 5, 6, 2, 3);

        int area = histograms.getMaxArea();

        assertThat(area, is(10));
    }
}
