package tw.ymeng.algorithm.proposition;

import static java.lang.Math.max;

public final class MaxSubSum {

    public static int maxSubSum(int[] array) {
        return maxSumRec(array, 0, array.length - 1);
    }

    private static int maxSumRec(int[] array, int left, int right) {
        if (left == right) {
            if (array[left] > 0) {
                return array[left];
            } else {
                return 0;
            }
        }

        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(array, left, center);
        int maxRightSum = maxSumRec(array, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += array[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += array[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max3(int a, int b, int c) {
        return max(max(a, b), c);
    }

    private MaxSubSum() {
    }
}
