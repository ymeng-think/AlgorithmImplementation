package tw.ymeng.algorithm.interview.polygon_filling.strategy;

public interface FillStrategy {

    void setGraph(char[][] graph);

    char[][] fill(Point start, char oldValue, char newValue);
}
