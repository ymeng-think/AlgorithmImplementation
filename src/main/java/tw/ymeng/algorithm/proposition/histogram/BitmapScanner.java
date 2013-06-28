package tw.ymeng.algorithm.proposition.histogram;

public class BitmapScanner {

    private final boolean[][] bitmap;
    private int width;
    private int height;

    public BitmapScanner(boolean[][] bitmap) {
        this.bitmap = bitmap;
        this.width = bitmap.length;
        this.height = bitmap[0].length;
    }

    public Rectangle getMaxRectangle() {
        int maxRectWidth = 0, maxRectHeight = 0;

        for (int j = 0; j < height; j++) {
            int rectWidth = 0;
            for (int i = 0; i < width; i++) {
                if (isMarked(i, j)) {
                    rectWidth++;
                } else {

                }
            }
            int rectHeight = j + 1;

            if (new Rectangle(rectWidth, rectHeight).isLargerThan(new Rectangle(maxRectWidth, maxRectHeight))) {
                maxRectWidth = rectWidth;
                maxRectHeight = rectHeight;
            }
        }

        return new Rectangle(maxRectWidth, maxRectHeight);
    }

    private boolean isMarked(int x, int y) {
        return bitmap[x][y];
    }
}
