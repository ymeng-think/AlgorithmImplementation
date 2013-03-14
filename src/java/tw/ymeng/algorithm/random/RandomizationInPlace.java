package tw.ymeng.algorithm.random;

import java.util.Random;

/*
* 不重复随机数组产生算法
*
* Algorithm Time Complexity = O(n)
*
* */
public class RandomizationInPlace {

    public int[] createRandomArray(int max) {
        int[] array = createSortedArray(max);

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int k = random.nextInt(array.length);
            swap(array, i, k);
        }

        return array;
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private int[] createSortedArray(int max) {
        int[] sortedArray = new int[max];
        for (int i = 0; i < max; i++) {
            sortedArray[i] = i + 1;
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        RandomizationInPlace random = new RandomizationInPlace();
        int[] randomArray = random.createRandomArray(50);
        print(randomArray);
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
