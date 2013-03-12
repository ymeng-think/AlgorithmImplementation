package tw.ymeng.algorithm.sorting.util;

public interface MergeStrategy {

    void merge(int[] items, int start, int mid, int end);
}
