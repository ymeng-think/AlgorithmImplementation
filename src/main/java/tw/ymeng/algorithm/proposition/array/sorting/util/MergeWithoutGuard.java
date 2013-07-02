package tw.ymeng.algorithm.proposition.array.sorting.util;

import static java.lang.System.arraycopy;

public class MergeWithoutGuard implements MergeStrategy {

    @Override
    public void merge(int[] items, int start, int mid, int end) {
        int[] temp1 = copyArray(items, start, mid - start + 1);
        int[] temp2 = copyArray(items, mid + 1, end - mid);

        int i = 0, j = 0, k = start;
        for (; k <= end && i < temp1.length && j < temp2.length; k++) {
            if (temp1[i] <= temp2[j]) {
                items[k] = temp1[i];
                i++;
            } else {
                items[k] = temp2[j];
                j++;
            }
        }

        if (i < temp1.length) {
            arraycopy(temp1, i, items, k, temp1.length - i);
        } else if (j < temp2.length) {
            arraycopy(temp2, j, items, k, temp2.length - j);
        }
    }

    private int[] copyArray(int[] items, int start, int length) {
        int[] temp = new int[length];
        arraycopy(items, start, temp, 0, length);
        return temp;
    }
}
