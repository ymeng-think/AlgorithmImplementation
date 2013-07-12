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
        if (isInBoundary(x, y) && graph[x][y] == oldValue) {
            graph[x][y] = newValue;

            for (Offset offset : direction.offsets()) {
                fill(x + offset.x(), y + offset.y(), oldValue, newValue);
            }
        }

        return graph;
    }

    private boolean isInBoundary(int x, int y) {
        return x >= 0 && y >= 0 && x < graph[0].length && y < graph.length;
    }
}
