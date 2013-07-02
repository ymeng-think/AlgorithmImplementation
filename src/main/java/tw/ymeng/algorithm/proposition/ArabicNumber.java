package tw.ymeng.algorithm.proposition;

import java.util.Stack;

public class ArabicNumber {

    private static final String[] chineseDigits = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] carryList = {"", "拾", "伯", "仟"};

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

        while (!numberElements.empty()) {
            word.append(chineseDigits[numberElements.pop()]);
            word.append(carryList[numberElements.size()]);
        }

        return word.toString();
    }
}
