package tw.ymeng.algorithm.interview.polygon_filling;

public class GraphBuilder {

    private int width;
    private char[] array;

    private GraphBuilder(int width) {
        this.width = width;
    }

    public static GraphBuilder graph(int width) {
        return new GraphBuilder(width);
    }

    public char[][] build() {
        return new char[0][];
    }

    public GraphBuilder map(char[] array) {
        this.array = array;
        return this;
    }
}
