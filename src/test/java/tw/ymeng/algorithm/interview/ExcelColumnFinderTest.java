package tw.ymeng.algorithm.interview;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ExcelColumnFinderTest {

    @Test
    public void should_find_first_column_label_in_excel() {
        ExcelColumnFinder finder = new ExcelColumnFinder();

        assertThat(finder.find(1), is("A"));
    }
}
