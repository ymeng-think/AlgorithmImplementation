package tw.ymeng.algorithm.interview.polygon_filling.strategy;

public enum Direction {
    Eight(new int[]{-1, 0}, new int[]{-1, 1}, new int[]{0, 1}, new int[]{1, 1},
            new int[]{1,  0}, new int[]{1, -1}, new int[]{0, -1}, new int[]{-1, -1});

    private Direction(int[]... directions) {
        this.offsets = new Offset[directions.length];

        for (int i = 0; i < this.offsets.length; i++) {
            this.offsets[i] = convertToOffset(directions[i]);
        }
    }

    public Offset[] offsets() {
        return offsets;
    }

    private Offset convertToOffset(int[] direction) {
        return new Offset(direction[0], direction[1]);
    }

    private Offset[] offsets;
}
