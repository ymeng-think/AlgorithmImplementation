package tw.ymeng.algorithm.utils;

public final class Swapper {

    public static void swap(char[] items, int index1, int index2) {
        if (index1 == index2) {
            return;
        }

        char temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    public static void swap(int[] items, int index1, int index2) {
        if (index1 == index2) {
            return;
        }

        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    public static <T> void swap(T[] items, int from, int to) {
        if (from == to) {
            return;
        }

        T temp = items[from];
        items[from] = items[to];
        items[to] = temp;
    }
}
