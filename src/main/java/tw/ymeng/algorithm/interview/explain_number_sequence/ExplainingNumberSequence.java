package tw.ymeng.algorithm.interview.explain_number_sequence;

import static java.lang.Integer.parseInt;

/**
 * Question (From Amazon):
 *  1, 11, 21, 1211, 求下一排的数字
 */
public class ExplainingNumberSequence {

    private static final int ZERO_IN_ASCII = 48;
    private int seed;

    public ExplainingNumberSequence(int seed) {
        this.seed = seed;
    }

    public ExplainingNumberSequence next() {
        DigitSequence digitSequence = new DigitSequence();
        for (char digit : convertToChars(seed)) {
            digitSequence.add(digit);
        }

        seed = parseInt(digitSequence.toString());

        return this;
    }

    public int currentSeed() {
        return seed;
    }

    private char[] convertToChars(int number) {
        char[] chars = new char[String.valueOf(number).length()];
        int index = chars.length - 1;

        while (number != 0) {
            chars[index--] = (char)(ZERO_IN_ASCII + number % 10);
            number /= 10;
        }

        return chars;
    }
}
