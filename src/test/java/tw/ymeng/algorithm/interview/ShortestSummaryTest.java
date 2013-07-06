package tw.ymeng.algorithm.interview;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ShortestSummaryTest {

    @Test
    public void should_extract_the_shortest_summary_included_all_keywords_from_description() {
        ShortestSummary shortestSummary = new ShortestSummary(
                "the set includes the 2013-w american eagle silver reverse proof coin",
                new String[]{"eagle", "proof"});

        String summary = shortestSummary.extract();

        assertThat(summary, is("eagle silver reverse proof"));
    }
}
