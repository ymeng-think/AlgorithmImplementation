package tw.ymeng.algorithm.interview.polygon_filling.strategy;

import tw.ymeng.algorithm.interview.polygon_filling.FillStrategy;

public class FillAlgorithmFactory {

    public static FillStrategy floodFillAlgorithm() {
        return new FloodFillAlgorithm();
    }

    private FillAlgorithmFactory() {
    }
}
