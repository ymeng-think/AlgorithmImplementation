package tw.ymeng.algorithm.proposition.histogram;

class Rectangle {

    public static final Rectangle NULL = new Rectangle(0, 0);

    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public boolean isLargerThan(Rectangle rectangle) {
        return area() > rectangle.area();
    }

    public long area() {
        return width * height;
    }
}
