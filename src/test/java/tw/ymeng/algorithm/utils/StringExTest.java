package tw.ymeng.algorithm.utils;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static tw.ymeng.algorithm.utils.StringEx.join;

public class StringExTest {

    @Test
    public static void should_concat_string_with_separator() {
        String[] strings = {"a", "b", "c"};

        String concatenation = join(strings, ",");

        assertThat(concatenation, is("a,b,c"));
    }
}
