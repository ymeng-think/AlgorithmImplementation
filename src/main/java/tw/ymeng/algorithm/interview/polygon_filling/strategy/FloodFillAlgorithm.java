package tw.ymeng.algorithm.interview.polygon_filling.strategy;

class FloodFillAlgorithm implements FillStrategy {

    private final Direction direction;
    private char[][] graph;

    FloodFillAlgorithm(Direction direction) {
        this.direction = direction;
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
        if (x >= 0 && y >= 0 &&
                graph[x][y] == oldValue) {
            graph[x][y] = newValue;

            for (Offset offset : direction.offsets()) {
                fill(x + offset.x(), y + offset.y(), oldValue, newValue);
            }
        }

        return graph;
    }
}
