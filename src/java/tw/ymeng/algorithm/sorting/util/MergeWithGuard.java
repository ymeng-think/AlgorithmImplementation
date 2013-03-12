package tw.ymeng.algorithm.sorting.util;

import static java.lang.System.arraycopy;

public class MergeWithGuard implements MergeStrategy {

    private static final int GUARD = 1000000;

    @Override
    public void merge(int[] items, int start, int mid, int end) {
        int[] temp1 = copyArrayWithGuard(items, start, mid - start + 1, GUARD);
        int[] temp2 = copyArrayWithGuard(items, mid + 1, end - mid, GUARD);

        for (int i = 0, j = 0, k = start; k <= end; k++) {
            if (temp1[i] <= temp2[j]) {
                items[k] = temp1[i];
                i++;
            } else {
                items[k] = temp2[j];
                j++;
            }
        }
    }

    private static int[] copyArrayWithGuard(int[] items, int start, int length, int guard) {
        int[] temp = new int[length + 1];
        arraycopy(items, start, temp, 0, length);
        temp[length] = guard;

        return temp;
    }
}
