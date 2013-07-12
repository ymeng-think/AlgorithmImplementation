package tw.ymeng.algorithm.interview.polygon_filling.strategy;

class FloodFillAlgorithm implements FillStrategy {

    private int[][] direction8 = new int[8][];
    private char[][] graph;

    public FloodFillAlgorithm() {
        direction8[0] = new int[]{-1,  0};
        direction8[1] = new int[]{-1,  1};
        direction8[2] = new int[]{ 0,  1};
        direction8[3] = new int[]{ 1,  1};
        direction8[4] = new int[]{ 1,  0};
        direction8[5] = new int[]{ 1, -1};
        direction8[6] = new int[]{ 0, -1};
        direction8[7] = new int[]{-1, -1};
    }

    @Override
    public void setGraph(char[][] graph) {
        this.graph = graph;
    }

    @Override
    public char[][] fill(Point start, char oldValue, char newValue) {
        return fill(start.x(), start.y(), oldValue, newValue);
    }

    private char[][] fill(int x, int y, char oldValue, char newValue) {
        if (graph[x][y] == oldValue) {
            graph[x][y] = newValue;

            for (int[] aDirection8 : direction8) {
                fill(x + aDirection8[0], y + aDirection8[1], oldValue, newValue);
            }
        }
        return graph;
    }
}
