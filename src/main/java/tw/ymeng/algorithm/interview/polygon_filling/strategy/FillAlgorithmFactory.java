package tw.ymeng.algorithm.interview.polygon_filling.strategy;

public class FillAlgorithmFactory {

    public static FillStrategy floodFillAlgorithm() {
        return new FloodFillAlgorithm();
    }

    private FillAlgorithmFactory() {
    }
}
