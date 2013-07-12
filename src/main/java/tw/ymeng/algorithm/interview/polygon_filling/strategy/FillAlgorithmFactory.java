package tw.ymeng.algorithm.interview.polygon_filling.strategy;

public class FillAlgorithmFactory {

    public static FillStrategy floodFillWithDirection8() {
        return new FloodFillAlgorithm(Direction.Eight);
    }

    public static FillStrategy floodFillWithDirection4() {
        return new FloodFillAlgorithm(Direction.Four);
    }

    private FillAlgorithmFactory() {
    }
}
