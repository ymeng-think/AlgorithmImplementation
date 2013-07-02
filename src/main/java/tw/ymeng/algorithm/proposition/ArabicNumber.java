package tw.ymeng.algorithm.proposition;

import java.util.Stack;

public class ArabicNumber {

    private static final String[] CHINESE_DIGITS = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] CARRY_LIST = {"", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟"};
    private static final String ZERO = "零";

    private int number;

    public ArabicNumber(int number) {
        this.number = number;
    }

    public String toChineseWord() {
        int decimalNumber = number;

        Stack<Integer> numberElements = new Stack<Integer>();
        while (decimalNumber != 0) {
            numberElements.push(decimalNumber % 10);

            decimalNumber /= 10;
        }

        return buildChineseWord(numberElements);
    }

    private String buildChineseWord(Stack<Integer> numberElements) {
        StringBuilder word = new StringBuilder();

        boolean containsZero = false;
        while (!numberElements.empty()) {
            Integer digit = numberElements.pop();
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

        return word.toString();
    }
}
