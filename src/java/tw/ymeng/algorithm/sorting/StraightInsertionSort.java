package tw.ymeng.algorithm.sorting;

/*
*
* Algorithm Time Complexity = O(n^2)
*
* */
public class StraightInsertionSort {

    public static int[] sort(int[] items) {
        return sort(items, 0, items.length - 1);
    }

    private static int[] sort(int[] items, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int insertedItem = items[i];
            for (int j = start; j < i; j++) {
                if (insertedItem < items[j]) {
                    Mover.move(items, j, i - 1);
                    items[j] = insertedItem;
                    break;
                }
            }
        }

        return items;
    }

}
