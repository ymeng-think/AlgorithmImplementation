package tw.ymeng.algorithm.proposition;

/*
* 输入一个数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字。
*  要求时间复杂度是O(n)。
* 如果有多对数字的和等于输入的数字，输出任意一对即可。
*  例如输入数组1、2、4、7、11、15和数字15。由于4+11=15，因此输出4和11。
* */
public class DigitSum {

    public static final int[] NULL = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
    private final int[] numbers;

    public DigitSum(int... numbers) {
        this.numbers = numbers;
    }

    public int[] is(int sum) {
        for (int i = 0, j = numbers.length - 1, step = 0; i < j; step++) {
            if (sum(numbers[i], numbers[j]) == sum) {
                return array(numbers[i], numbers[j]);
            }

            if (step % 2 == 0) {
                i++;
            } else {
                j--;
            }
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
