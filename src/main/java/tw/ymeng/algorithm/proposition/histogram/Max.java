package tw.ymeng.algorithm.proposition.histogram;

import static java.lang.Integer.MIN_VALUE;

class Max {

    public static int max(int[] array) {
        int max = MIN_VALUE;
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
