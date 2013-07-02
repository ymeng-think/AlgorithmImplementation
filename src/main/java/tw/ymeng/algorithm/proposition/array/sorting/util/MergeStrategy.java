package tw.ymeng.algorithm.proposition.array.sorting.util;

public interface MergeStrategy {

    void merge(int[] items, int start, int mid, int end);
}
