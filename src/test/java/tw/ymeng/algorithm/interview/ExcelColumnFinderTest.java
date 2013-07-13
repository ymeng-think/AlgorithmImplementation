package tw.ymeng.algorithm.interview;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ExcelColumnFinderTest {

    @Test
    public void should_find_label_of_the_first_excel_column() {
        ExcelColumnFinder finder = new ExcelColumnFinder();

        assertThat(finder.find(1), is("A"));
    }

    @Test
    public void should_find_label_of_column_that_index_is_greater_than_26() {
        ExcelColumnFinder finder = new ExcelColumnFinder();

        assertThat(finder.find(28), is("AB"));
    }

    @Test
    public void should_pass_case_2() {
        ExcelColumnFinder finder = new ExcelColumnFinder();

        assertThat(finder.find(54), is("BB"));
    }

    @Test
    public void should_pass_case_3() {
        ExcelColumnFinder finder = new ExcelColumnFinder();

        assertThat(finder.find(10000), is("NTP"));
    }
}
