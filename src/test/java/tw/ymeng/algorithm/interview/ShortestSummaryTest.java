package tw.ymeng.algorithm.interview;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ShortestSummaryTest {

    @Test
    public void should_extract_the_shortest_summary_included_all_keywords_from_description() {
        ShortestSummary shortestSummary = new ShortestSummary(
                "the set includes the 2013-w american eagle silver reverse proof coin",
                new String[]{"the", "eagle", "proof"});

        String summary = shortestSummary.extract();

        assertThat(summary, is("the 2013-w american eagle silver reverse proof"));
    }

    @Test
    public void should_extract_the_shortest_summary_included_all_keywords_from_description_with_case_insensitive_way() {
        ShortestSummary shortestSummary = new ShortestSummary(
                "The set includes the 2013-W American Eagle Silver Reverse Proof Coin",
                new String[]{"eagle", "proof"});

        String summary = shortestSummary.extract();

        assertThat(summary, is("Eagle Silver Reverse Proof"));
    }

    @Test
    public void should_choose_the_shortest_one_when_summary_that_includes_all_keywords_appears_multi_times() {
        ShortestSummary shortestSummary = new ShortestSummary(
                "eagle silver reverse proof coin eagle silver coin in america",
                new String[]{"eagle", "coin"});

        String summary = shortestSummary.extract();

        assertThat(summary, is("coin eagle"));
    }
}
