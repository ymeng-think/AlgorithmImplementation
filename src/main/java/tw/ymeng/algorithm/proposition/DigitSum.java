package tw.ymeng.algorithm.proposition;

public class DigitSum {

    public static final int[] NULL = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
    private final int[] numbers;

    public DigitSum(int... numbers) {
        this.numbers = numbers;
    }

    public int[] is(int sum) {
        if (sum(numbers[0], numbers[1]) == sum) {
            return array(numbers[0], numbers[1]);
        }
        return NULL;
    }

    private int[] array(int a, int b) {
        return new int[]{a, b};
    }

    private int sum(int a, int b) {
        return a + b;
    }
}
