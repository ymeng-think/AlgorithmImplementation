package tw.ymeng.algorithm.interview.array_combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Amazon Hiring Test - Merchant II

    Question 3 / 3 (combine array)

    NOTE: This is a coding test, please write a runnable code and try compile/run to pass all test cases. And after you
    submit, please verify your pass rate and go back to check if your code has some errors or not.
    Merge two sorted integer array into one sorted array .

    Example1
    Input:
        1  3 5  7 9
        2 4 6 8 10
    Ouput:
        1 2 3 4 5 6 7 8 9 10


    Example2
    Input:
        9 8 6 3 2
        7 6 3 2
    Output:
        9 8 7 6 6 3 3 2 2
* */
public class Solution {

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

}