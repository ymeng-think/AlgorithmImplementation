package tw.ymeng.algorithm.interview.array_combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution2 {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input1 = reader.readLine();
        String input2 = reader.readLine();

        IntArrayParser parser = new IntArrayParser();
        int[] array1 = parser.parse(input1);
        int[] array2 = parser.parse(input2);

        Combiner combiner = new Combiner();
        int[] result = combiner.combine(array1, array2);

        printArray(result);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    private static class Combiner {

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

    private static class IntArrayParser {

        public int[] parse(String text) {
            String[] tokens = text.split("\\s+");
            int[] array = new int[tokens.length];

            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(tokens[i]);
            }

            return array;
        }
    }

}