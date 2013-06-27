package tw.ymeng.algorithm.proposition;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HistogramCollectionTest {

    @Test
    public void should_get_max_area_when_there_is_only_one_in_histogram_list() {
        HistogramCollection histograms = new HistogramCollection(2);

        int area = histograms.getMaxArea();

        assertThat(area, is(2));
    }
}
