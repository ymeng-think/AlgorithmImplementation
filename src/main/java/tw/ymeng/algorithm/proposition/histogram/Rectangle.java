package tw.ymeng.algorithm.proposition.histogram;

class Rectangle {

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
