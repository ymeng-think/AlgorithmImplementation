package tw.ymeng.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

/*
* Find common elements or intersection in a 2D array.
* */
public class CommonElementsIn2DArray {

    public int[] findCommonElements(int[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array should not be null.");
        }

        int[] insected = array[0];
        for (int i = 1; i < array.length; i++) {
            insected = insect(insected, array[i]);
        }

        return insected;
    }

    private int[] insect(int[] arr1, int[] arr2) {
        List<Integer> commonElements = new ArrayList<Integer>();

        for (int i = 0, j = 0; i < arr1.length && j < arr2.length; ) {
            if (arr1[i] == arr2[j]) {
                commonElements.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return convertToIntArray(commonElements);
    }

    private int[] convertToIntArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}
