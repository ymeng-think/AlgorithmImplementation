package tw.ymeng.algorithm.sorting;

/*
* 简单选择排序

每一趟从待排序的数据元素中选出最小（或最大）的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。
选择排序不像冒泡排序算法那样先并不急于调换位置，第一轮（k=1）先从array[k]开始逐个检查，看哪个数最小就记下该数所在的位置于minlIndex中，
等一轮扫描完毕，如果找到比array[k-1]更小的元素，则把array[minlIndex]和a[k-1]对调，这时array[k]到最后一个元素中最小的元素就换到了
array[k-1]的位置。 如此反复进行第二轮、第三轮… 直到循环至最后一元素。

Sample
初始状态： 2 4 3 1
  (1) 最小值为1, 与第一个交换     1]  4   3   2
  (2) 最小值为2, 与第二个交换     1   2］ 3   4
  (3) 3就是最小值，无需交换，完成  1   2   3   4
*
* */
public class SelectSort {

    public static int[] sort(int[] items) {
        return sort(items, 0, items.length - 1);
    }

    private static int[] sort(int[] items, int start, int end) {
        for (int i = start; i <= end; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= end; j++) {
                if (items[j] < items[minIndex]) {
                    minIndex = j;
                }
            }

            swap(items, minIndex, i);
        }

        return items;
    }

    private static void swap(int[] items, int from, int to) {
        if (from == to) {
            return;
        }

        int temp = items[from];
        items[from] = items[to];
        items[to] = temp;
    }
}
