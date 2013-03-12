package tw.ymeng.algorithm.sorting;

import static java.lang.System.arraycopy;

/*
* 归并排序

Algorithm Time Complexity = O(nlgn)

归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。

归并操作

归并操作(merge)，也叫归并算法，指的是将两个已经排序的序列合并成一个序列的操作。
  如　设有数列{6，202，100，301，38，8，1}
  初始状态： [6] [202] [100] [301] [38] [8] [1] 　比较次数
    i=1 　[6 202 ] [ 100 301] [ 8 38] [ 1 ]　 3
    i=2 　[ 6 100 202 301 ] [ 1 8 38 ]　 4
    i=3　 [ 1 6 8 38 100 202 301 ] 　4
  总计：　11次
* */
public class MergeSort implements Sort {

    private int[] items;
    private MergeStrategy mergeStrategy;

    private MergeSort(int[] items, MergeStrategy mergeStrategy) {
        this.items = items;
        this.mergeStrategy = mergeStrategy;
    }

    public static MergeSort MergeSortWithGuard(int[] items) {
        return new MergeSort(items, new MergeWithGuard());
    }

    public static Sort MergeSortWithoutGuard(int[] unsorted) {
        return new MergeSort(unsorted, new MergeWithoutGuard());
    }

    @Override
    public int[] sort() {
        return doMergeSort(0, items.length - 1);
    }

    private int[] doMergeSort(int start, int end) {
        if (start < end) {
            int mid = (end + start) / 2;
            doMergeSort(start, mid);
            doMergeSort(mid + 1, end);
            mergeStrategy.merge(items, start, mid, end);
        }
        return items;
    }
}
