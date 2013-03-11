package tw.ymeng.algorithm.sorting;

import static tw.ymeng.algorithm.sorting.Mover.move;

/*
*
* Algorithm Time Complexity = O(n^2)

一般直接插入排序的时间复杂度为O ( n^2 ) ，但是当数列基本有序时，如果按照有数列顺序排时，时间复杂度将改善到O( n )，另外，因直接插入排序
算法简单，如果待排序列规模不很大时效率也较高。

在已经排好序的序列中查找待插入的元素的插入位置，并将待插入元素插入到有序列表中的过程。

将数组分成两部分，初始化时，前部分数组为只有第一个元素，用来存储已排序元素，我们这里叫 arr1 ；后部分数组的元素为除第一个元素的所有元素，
为待排序或待插入元素，我们这里叫 arr2 。
排序时使用二层循环：第一层对 arr2 进行循环，每次取后部分数组（待排序数组）里的第一个元素（我们称为待排序元素或称待插入元素） e1 ，然后
在第二层循环中对 arr1 （已排好序的数组）从第一个元素往后进行循环，查到第一个大于待插入元素（如果是升序排列）或第一个小于待插入元素（如果
是降序排列） e2 ，然后对 arr1 从 e2 元素开始往后的所有元素向后移，最后把 e1 插入到原来 e2 所在的位置。这样反复地对 arr2 进行循环，直到
arr2 中所有的待插入的元素都插入到 arr1 中。
*
* */
public class StraightInsertionSort {

    public static int[] sort(int[] items) {
        return sort(items, 0, items.length - 1);
    }

    private static int[] sort(int[] items, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int insertedItem = items[i];
            for (int j = start; j < i; j++) {
                if (insertedItem < items[j]) {
                    move(items, j, i - 1);
                    items[j] = insertedItem;
                    break;
                }
            }
        }

        return items;
    }

}
