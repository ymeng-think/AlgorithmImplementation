package tw.ymeng.algorithm.sorting;

import static tw.ymeng.algorithm.sorting.Swapper.swap;

public class BubbleSort implements Sort {

    private int[] items;

    public BubbleSort(int[] items) {
        this.items = items;
    }

    @Override
    public int[] sort() {
        return sort(0, items.length - 1);
    }

    private int[] sort(int start, int end) {
        for (int i = start; i < end; i++) {
            for (int j = start; j < end - i; j++) {
                if (items[j] > items[j + 1]) {
                    swap(items, j, j + 1);
                }
            }
        }

        return items;
    }
}
