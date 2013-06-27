package tw.ymeng.algorithm.proposition.histogram;

public class Bitmap {

    private final boolean[][] bitmap;

    public static Bitmap bitmap(int width, int height) {
        return new Bitmap(width, height);
    }

    public boolean[][] build() {
        return bitmap;
    }

    public Bitmap with(int... bitNumList) {
        for (int i = 0; i < bitNumList.length; i++) {
            setTrueBeforeIndex(bitmap[i], bitNumList[i]);
        }
        return this;
    }

    private void setTrueBeforeIndex(boolean[] bits, int index) {
        for (int i = 0; i < index; i++) {
            bits[i] = true;
        }
    }

    private Bitmap(int width, int height) {
        this.bitmap = createBitmap(width, height);
    }

    private static boolean[][] createBitmap(int width, int height) {
        boolean[][] bitmap = new boolean[width][];
        for (int i = 0; i < width; i++) {
            bitmap[i] = new boolean[height];
        }

        return bitmap;
    }
}
