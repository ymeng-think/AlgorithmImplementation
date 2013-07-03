package tw.ymeng.algorithm.interview;

import java.util.Stack;

/**
 * Question (from Amazon):
 *  数字转成汉字
 * */
public class ArabicNumber {

    private static final char[] CHINESE_DIGITS = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    private static final String[] CARRY_LIST = {"", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟"};
    private static final char ZERO = '零';
    private static final String TEN = "壹拾";
    private static final char TEN_THOUSAND = '万';
    private static final char HUNDRED_MILLION = '亿';

    private long number;

    public ArabicNumber(long number) {
        this.number = number;
    }

    public String toChineseWord() {
        Stack<Character> numberElements = extractNumberElements(number);
        return buildChineseWord(numberElements);
    }

    private Stack<Character> extractNumberElements(long decimalNumber) {
        Stack<Character> numberElements = new Stack<Character>();
        while (decimalNumber != 0) {
            numberElements.push((char)(decimalNumber % 10));

            decimalNumber /= 10;
        }
        return numberElements;
    }

    private String buildChineseWord(Stack<Character> numberElements) {
        StringBuilder word = new StringBuilder();

        boolean containsZero = false;
        while (!numberElements.empty()) {
            char digit = numberElements.pop();

            if (needToAppendHundredMillionCarry(digit, numberElements.size())) {
                word.append(HUNDRED_MILLION);
            } else if (needToAppendTenThousandCarry(word, digit, numberElements.size())) {
                word.append(TEN_THOUSAND);
            }

            if (digit == 0) {
                containsZero = true;
                continue;
            }

            if (containsZero) {
                word.append(ZERO);
                containsZero = false;
            }

            word.append(CHINESE_DIGITS[digit]);
            word.append(CARRY_LIST[numberElements.size()]);
        }

        String chineseWord = word.toString();
        chineseWord = ignore1X(chineseWord);

        return chineseWord;
    }

    private boolean needToAppendHundredMillionCarry(char currentDigit, int remainderSize) {
        return currentDigit == 0 && remainderSize == 8;
    }

    private boolean needToAppendTenThousandCarry(StringBuilder word, char currentDigit, int remainderSize) {
        return currentDigit == 0 && remainderSize == 4 && word.charAt(word.length() - 1) != HUNDRED_MILLION;
    }

    private String ignore1X(String chineseWord) {
        return chineseWord.startsWith(TEN) ? chineseWord.substring(1) : chineseWord;
    }
}
