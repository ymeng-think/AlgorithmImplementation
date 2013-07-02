package tw.ymeng.algorithm.proposition;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArabicNumberTest {

    @Test
    public void should_convert_single_digit_to_chinese_word() {
        ArabicNumber number = new ArabicNumber(2);

        assertThat(number.toChineseWord(), is("贰"));
    }

    @Test
    public void should_convert_decimal_number_to_chinese_word() {
        ArabicNumber number = new ArabicNumber(123);

        assertThat(number.toChineseWord(), is("壹佰贰拾叁"));
    }

    @Test
    public void should_convert_very_large_decimal_number_to_chinese_word() {
        ArabicNumber number = new ArabicNumber(1987654321);

        assertThat(number.toChineseWord(), is("壹拾玖亿捌仟柒佰陆拾伍万肆仟叁佰贰拾壹"));
    }
}
