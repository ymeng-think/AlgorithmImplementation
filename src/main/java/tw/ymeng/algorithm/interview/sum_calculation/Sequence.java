package tw.ymeng.algorithm.interview.sum_calculation;

public class Sequence {

    private final int element;
    private final int number;

    public Sequence(int element, int number) {

        this.element = element;
        this.number = number;
    }


    public int value() {
        return element * number;
    }
}
