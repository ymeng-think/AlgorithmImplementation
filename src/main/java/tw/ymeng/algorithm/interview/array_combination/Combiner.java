package tw.ymeng.algorithm.interview.array_combination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Combiner {

    public int[] combine(int[] array1, int[] array2) {
        boolean isAsc = isAsc(array1);
        List<Integer> list1 = convertIntArrayToList(array1);
        List<Integer> list2 = convertIntArrayToList(array2);

        list1.addAll(list2);
        Collections.sort(list1, buildComparer(isAsc));

        return convertIntListToArray(list1);
    }

    private Comparator<? super Integer> buildComparer(boolean isAsc) {
        if (isAsc) {
            return new Comparator<Integer>() {
                @Override
                public int compare(Integer i1, Integer i2) {
                    return i1.compareTo(i2);
                }
            };
        } else {
            return new Comparator<Integer>() {
                @Override
                public int compare(Integer i1, Integer i2) {
                    return i2.compareTo(i1);
                }
            };
        }
    }

    private boolean isAsc(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return true;
            }
        }
        return false;
    }

    private int[] convertIntListToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        return array;
    }

    private List<Integer> convertIntArrayToList(int[] array) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : array) {
            list.add(i);
        }

        return list;
    }
}
