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
        if (array == null) {
            return new char[0][0];
        }

        int height = array.length / width;
        char[][] chars = new char[height][];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = new char[width];
            for (int j = 0; j < chars[i].length; j++) {
                chars[i][j] = convertToNumericChar(array[width * i + j]);
            }
        }

        return chars;
    }

    private char convertToNumericChar(char c) {
        return (char)(c + 48);
    }

    public GraphBuilder map(char[] array) {
        this.array = array;
        return this;
    }
}
