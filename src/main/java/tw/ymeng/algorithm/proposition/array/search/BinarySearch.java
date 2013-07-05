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
        return search(item, 0, items.length - 1);
    }

    public int searchPrevItem(int item) {
        return searchPrevItem(item, 0, items.length - 1);
    }

    public int searchNextItem(int item) {
        return searchNextItem(item, 0, items.length - 1);
    }

    public int searchInRange(int target, int start, int end) {
        int mid;
        int left = start - 1;
        int right = end + 1;

        while (left + 1 != right) {
            mid = left + (right - left) / 2;
            if (items[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (right <= end && items[right] == target) {
            return right;
        }

        return -1;
    }

    private int search(int target, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (items[mid] == target) {
                return mid;
            } else if (items[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private int searchPrevItem(int target, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (items[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (start - 1 >= 0) {
            return start - 1;
        }

        return -1;
    }

    private int searchNextItem(int target, int start, int end) {
        int length = end + 1;
        while (start < end) {
            int mid = start + (end - start + 1) / 2;

            if (items[mid] <= target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        if (end + 1 < length) {
            return end + 1;
        }

        return -1;
    }
}
