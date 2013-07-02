package tw.ymeng.algorithm.proposition.array.search;

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

    public int searchPrevItem(int item) {
        return searchPrevItem(0, items.length - 1, item);
    }

    public int searchNextItem(int item) {
        return searchNextItem(0, items.length - 1, item);
    }

    private int search(int low, int high, int item) {
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (items[mid] == item) {
                return mid;
            } else if (items[mid] > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int searchPrevItem(int low, int high, int item) {
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (items[mid] >= item) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        if (low - 1 >= 0) {
            return low - 1;
        }

        return -1;
    }

    private int searchNextItem(int low, int high, int item) {
        int length = high + 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;

            if (items[mid] <= item) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        if (high + 1 < length) {
            return high + 1;
        }

        return -1;
    }
}
