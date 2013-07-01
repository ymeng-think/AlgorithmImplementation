package tw.ymeng.algorithm.proposition.histogram;

class VerticalBitRectangle {
    public static final VerticalBitRectangle NULL = new VerticalBitRectangle(-1, 0, 0);

    private final int start;
    private final int width;
    private final int height;

    public VerticalBitRectangle(int start, int width, int height) {
        this.start = start;
        this.width = width;
        this.height = height;
    }

    public long area() {
        return width * height;
    }

    public VerticalBitRectangle merge(boolean[] bitArray) {
        int newStart = start;
        int newHeight = 0, newWidth = width;
        for (int i = newStart; i < bitArray.length; i++) {
            if (!bitArray[i]) {
                break;
            }
            newHeight++;
        }

        if (newHeight > 0) {
            newWidth++;
            newHeight = Math.min(height, newHeight);
        }

        return new VerticalBitRectangle(newStart, newWidth, newHeight);
    }

    public static VerticalBitRectangle convertFrom(boolean[] bitArray) {
        int start = -1;
        int height = 0;
        for (int i = 0; i < bitArray.length; i++) {
            if (!bitArray[i]) {
                if (height > 0) {
                    break;
                } else {
                    continue;
                }
            }

            if (start < 0) {
                start = i;
            }
            height++;
        }
        return new VerticalBitRectangle(start, 1, height);
    }

    public boolean isLargerThan(VerticalBitRectangle other) {
        return this.area() > other.area();
    }
}
