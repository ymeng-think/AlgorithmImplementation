package tw.ymeng.algorithm.proposition;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArabicNumberTest {

    @Test
    public void should_convert_single_digit_to_chinese_character() {
        ArabicNumber number = new ArabicNumber(2);

        assertThat(number.toChineseWord(), is("贰"));
    }
}
