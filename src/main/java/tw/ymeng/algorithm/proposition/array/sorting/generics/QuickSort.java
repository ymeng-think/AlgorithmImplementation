package tw.ymeng.algorithm.proposition.array.sorting.generics;

import java.util.Comparator;

public class QuickSort<T> implements Sort<T> {

    private T[] items;
    private Comparator<T> comparator;

    private QuickSort(T[] items, Comparator<T> comparator) {
        this.items = items;
        this.comparator = comparator;
    }

    public static <T> T[] qsort(T[] items, Comparator<T> comparator) {
        return new QuickSort<T>(items, comparator).sort();
    }

    @Override
    public T[] sort() {
        return sort(0, items.length - 1);
    }

    private T[] sort(int start, int end) {
        if (start < end) {
            int pivot = partition(start, end);
            sort(start, pivot - 1);
            sort(pivot + 1, end);
        }

        return items;
    }

    private int partition(int start, int end) {
        int i = start, j = end;
        T pivotKey = items[start];

        while (i < j) {
            while (i < j && comparator.compare(items[j], pivotKey) >= 0) {
                j--;
            }
            items[i] = items[j];

            while (i < j && comparator.compare(items[i], pivotKey) <= 0) {
                i++;
            }
            items[j] = items[i];
        }

        items[i] = pivotKey;

        return i;
    }
}
