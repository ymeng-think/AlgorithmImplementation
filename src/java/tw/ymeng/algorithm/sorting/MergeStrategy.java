package tw.ymeng.algorithm.sorting;

/**
 * Created with IntelliJ IDEA.
 * User: ymeng
 * Date: 3/12/13
 * Time: 12:29 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MergeStrategy {
    void merge(int[] items, int start, int mid, int end);
}
