package tw.ymeng.algorithm.sorting;

class Swapper {

    public static void swap(int[] items, int from, int to) {
        if (from == to) {
            return;
        }

        int temp = items[from];
        items[from] = items[to];
        items[to] = temp;
    }
}
