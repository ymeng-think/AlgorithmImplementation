package tw.ymeng.algorithm.interview.sum_calculation;

/*
Amazon Hiring Test - Merchant II

Question 1 / 3 (calculate the sum)

NOTE: This is a coding test, please write a runnable code and try compile/run to pass all test cases.
And after you submit, please verify your pass rate and go back to check if your code has some errors or not.
Calculate the sum of  N+NN+NNN+NNNN ...    and there are total M N-sequence.

Input is :N[SPACE]M
Both M, N are positive integer. please output the sum

Example1
    Input: 1 2
then the sequence will be  1+11,
    Your output :12

Example2
    Input: 2 3
then the sequence will be  2+22+222,
    Your output :246
* */
public final class SequenceArrayParser {

    public static Sequence[] parse(String text) {
        String[] tokens = text.split("\\s+");

        int baseNumber = Integer.parseInt(tokens[0]);
        int times = Integer.parseInt(tokens[1]);

        Sequence[] array = new Sequence[times];

        for (int i = 0; i < array.length; i++) {
            array[i] = new Sequence(baseNumber, i + 1);
        }

        return array;
    }

    private SequenceArrayParser() {
    }
}
