package tw.ymeng.algorithm.proposition.array.sorting.generics;

public class Swapper {

    public static <T> void swap(T[] items, int from, int to) {
        if (from == to) {
            return;
        }

        T temp = items[from];
        items[from] = items[to];
        items[to] = temp;
    }
}
