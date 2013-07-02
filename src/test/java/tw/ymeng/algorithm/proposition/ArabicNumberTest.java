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
    public void should_ignore_the_first_character_when_number_start_with_1X() {
        ArabicNumber number = new ArabicNumber(10);

        assertThat(number.toChineseWord(), is("拾"));
    }

    @Test
    public void should_convert_decimal_number_to_chinese_word() {
        ArabicNumber number = new ArabicNumber(123);

        assertThat(number.toChineseWord(), is("壹佰贰拾叁"));
    }

    @Test
    public void should_convert_very_large_decimal_number_to_chinese_word() {
        ArabicNumber number = new ArabicNumber(1987654321);

        assertThat(number.toChineseWord(), is("拾玖亿捌仟柒佰陆拾伍万肆仟叁佰贰拾壹"));
    }

    @Test
    public void should_convert_decimal_number_that_ends_with_zero() {
        ArabicNumber number = new ArabicNumber(100);

        assertThat(number.toChineseWord(), is("壹佰"));
    }

    @Test
    public void should_skip_zero_when_convert_number_that_is_less_than_10000() {
        ArabicNumber number = new ArabicNumber(2003);

        assertThat(number.toChineseWord(), is("贰仟零叁"));
    }
}
