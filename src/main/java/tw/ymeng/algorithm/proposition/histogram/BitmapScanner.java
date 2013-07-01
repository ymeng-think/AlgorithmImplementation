package tw.ymeng.algorithm.proposition.histogram;

public class BitmapScanner {

    private final VerticalBitRectangle holder;
    private final boolean[][] bitmap;
    private int height;

    public BitmapScanner(boolean[][] bitmap) {
        this.bitmap = bitmap;
        this.height = bitmap[0].length;
        this.holder = VerticalBitRectangle.holder(height);
    }

    public VerticalBitRectangle getMaxRectangle() {
        return maxArea(0, bitmap.length - 1);
    }

    private VerticalBitRectangle maxArea(int left, int right) {
        if (left == right) {
            VerticalBitRectangle bitRectangle = VerticalBitRectangle.convertFrom(bitmap[left]);
            if (bitRectangle.area() > 0) {
                return bitRectangle;
            } else {
                return VerticalBitRectangle.NULL;
            }
        }

        int center = (left + right) / 2;
        VerticalBitRectangle maxLeftArea = maxArea(left, center);
        VerticalBitRectangle maxRightArea = maxArea(center + 1, right);

        VerticalBitRectangle maxLeftBorderArea = holder, leftBorderArea = holder;
        for (int i = center; i >= left; i--) {
            leftBorderArea = leftBorderArea.merge(bitmap[i]);
            if (leftBorderArea.isLargerThan(maxLeftBorderArea)) {
                maxLeftBorderArea = leftBorderArea;
            }
        }

        VerticalBitRectangle maxRightBorderArea = holder, rightBorderArea = holder;
        for (int i = center + 1; i <= right; i++) {
            rightBorderArea = rightBorderArea.merge(bitmap[i]);
            if (rightBorderArea.isLargerThan(maxRightBorderArea)) {
                maxRightBorderArea = rightBorderArea;
            }
        }

        return max3(maxLeftArea, maxRightArea, maxLeftBorderArea.merge(maxRightBorderArea));
    }

    private VerticalBitRectangle max3(VerticalBitRectangle a, VerticalBitRectangle b, VerticalBitRectangle c) {
        return max2(max2(a, b), c);
    }

    private VerticalBitRectangle max2(VerticalBitRectangle a, VerticalBitRectangle b) {
        return a.area() > b.area() ? a : b;
    }

}
