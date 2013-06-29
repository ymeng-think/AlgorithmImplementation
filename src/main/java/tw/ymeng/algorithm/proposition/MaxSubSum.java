package tw.ymeng.algorithm.proposition;

public final class MaxSubSum {

    public static final MaxSubSum DivideAndConquerAlgorithm = new MaxSubSum(new DivideAndConquer());
    public static final MaxSubSum LinearTimeAlgorithm = new MaxSubSum(new LinearTimeAlgorithm());

    private MaximumContiguousSubSequenceSum algorithm;

    private MaxSubSum(MaximumContiguousSubSequenceSum algorithm) {
        this.algorithm = algorithm;
    }

    public int maxSubSum(int[] array) {
        return algorithm.max(array);
    }



    private static interface MaximumContiguousSubSequenceSum {
        int max(int[] array);
    }

    private static class DivideAndConquer implements MaximumContiguousSubSequenceSum {

        @Override
        public int max(int[] array) {
            return maxSumRec(array, 0, array.length - 1);
        }

        private int maxSumRec(int[] array, int left, int right) {
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

        private int max3(int a, int b, int c) {
            return Math.max(Math.max(a, b), c);
        }
    }

    /*
    * Linear-time maximum contiguous subsequence sum algorithm.
    * */
    private static class LinearTimeAlgorithm implements MaximumContiguousSubSequenceSum {

        @Override
        public int max(int[] array) {
            int maxSum = 0, thisSum = 0;

            for (int i : array) {
                thisSum += i;

                if (thisSum > maxSum) {
                    maxSum = thisSum;
                } else if (thisSum < 0) {
                    thisSum = 0;
                }
            }

            return maxSum;
        }
    }
}

