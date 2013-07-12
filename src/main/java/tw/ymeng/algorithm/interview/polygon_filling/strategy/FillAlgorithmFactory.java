package tw.ymeng.algorithm.interview.polygon_filling.strategy;

public class FillAlgorithmFactory {

    public static FillStrategy floodFillAlgorithmWithDirection8() {
        return new FloodFillAlgorithm(Direction.Eight);
    }

    private FillAlgorithmFactory() {
    }
}
