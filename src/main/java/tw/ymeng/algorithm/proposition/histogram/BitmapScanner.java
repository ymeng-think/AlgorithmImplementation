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
        boolean[] prevMerged = emptyBitArray();
        Rectangle maxRect = Rectangle.NULL;

        for (int i = 0; i < width - 1; i++) {
            int maxRectWidth = 1, maxRectHeight = 1;
            for (int j = i + 1; j < width; j++) {
                boolean[] merged = merge(bitmap[i], bitmap[j]);

                if (!isLessThan(merged, prevMerged)) {
                    maxRectWidth++;
                    prevMerged = merged;
                }
            }
            maxRectHeight = calculateWidth(prevMerged);

            Rectangle newRect = new Rectangle(maxRectWidth, maxRectHeight);
            if (newRect.isLargerThan(maxRect)) {
                maxRect = newRect;
            }
        }

        return maxRect;
    }

    private int calculateWidth(boolean[] bitArray) {
        int counter = 0;
        for (int i = 0; i < bitArray.length; i++) {
            if (isMarked(bitArray, i)) {
                counter++;
            }
        }
        return counter;
    }

    private boolean isLessThan(boolean[] b1, boolean[] b2) {
        for (int i = 0; i < b1.length; i++) {
            if (!b1[i] && b2[i]) {
                return true;
            }
        }
        return false;
    }

    private boolean[] merge(boolean[] b1, boolean[] b2) {
        boolean[] merged = new boolean[b1.length];

        for (int i = 0; i < merged.length; i++) {
            merged[i] = b1[i] & b2[i];
        }

        return merged;
    }

    private boolean[] emptyBitArray() {
        return new boolean[height];
    }

    private static boolean isMarked(boolean[] bitArray, int index) {
        return bitArray[index];
    }
}
