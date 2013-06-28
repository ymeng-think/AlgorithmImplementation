package tw.ymeng.algorithm.proposition.histogram;

public class BitmapBuilder {

    public static final boolean X = false;
    public static final boolean O = true;

    public static boolean[][] build(int width, boolean[] values) {
        if (values.length % width != 0) {
            throw new IllegalArgumentException("Height is NOT integer.");
        }

        boolean[][] bitmap = new boolean[width][];
        for (int i = 0; i < width; i++) {
            bitmap[i] = extractFromValues(values, width, i);
        }

        return bitmap;
    }

    private static boolean[] extractFromValues(boolean[] values, int width, int index) {
        int height = values.length / width;
        boolean[] bits = new boolean[height];

        for (int i = 0; i < height; i++) {
            bits[height - 1 - i] = values[i * width + index];
        }

        return bits;
    }
}
