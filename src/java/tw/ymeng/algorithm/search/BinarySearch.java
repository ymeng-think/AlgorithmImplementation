package tw.ymeng.algorithm.search;

/*
*
* Algorithm Time Complexity = O(logn)
*
* */
public class BinarySearch {

    private int[] items;

    public BinarySearch(int[] items) {
        this.items = items;
    }

    public int search(int item) {
        return search(0, items.length - 1, item);
    }

    private int search(int start, int end, int item) {
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (items[mid] == item) {
                return mid;
            } else if (items[mid] > item) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
