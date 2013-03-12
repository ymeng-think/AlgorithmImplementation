package tw.ymeng.algorithm.sorting.util;

public class Mover {

    public static void move(int[] items, int from, int to) {
        move(items, from, to, 1);
    }

    public static void move(int[] items, int from, int to, int step) {
        for (int i = to; i >= from; i -= step) {
            items[i + step] = items[i];
        }
    }
}
