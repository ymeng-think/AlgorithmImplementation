package tw.ymeng.algorithm.interview.explain_number_sequence;

/**
 * Question (From Amazon):
 *  1, 11, 21, 1211, 求下一排的数字
 */
public class ExplainingNumberSequence {

    private char[] seed;

    public ExplainingNumberSequence(int seed) {
        this.seed = convertToChars(seed);
    }

    public int next() {
        return 11;
    }

    private char[] convertToChars(int number) {
        char[] chars = new char[String.valueOf(number).length()];
        int index = 0;

        while (number != 0) {
            chars[index++] = (char) (number % 10);
            number /= 10;
        }

        return chars;
    }
}
