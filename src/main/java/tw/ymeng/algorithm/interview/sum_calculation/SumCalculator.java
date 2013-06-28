package tw.ymeng.algorithm.interview.sum_calculation;

public class SumCalculator {

    public int sum(Sequence... sequenceArray) {
        int sum = 0;
        for (int i = 0; i < sequenceArray.length; i++) {
            sum *= 10;
            sum += sequenceArray[i].value();
        }

        return sum;
    }
}
