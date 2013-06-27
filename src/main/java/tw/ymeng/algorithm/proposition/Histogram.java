package tw.ymeng.algorithm.proposition;

/*
* 给定直方图，每一小块的height由N个非负整数所确定，每一小块的width都为1，请找出直方图中面积最大的矩形。
*  如下图所示，直方图中每一块的宽度都是1，每一块给定的高度分别是[2,1,5,6,2,3]：
* 那么上述直方图中，面积最大的矩形便是下图所示的阴影部分的面积，面积= 10单位。
*
*    |      _
*  6 |    _| |
*  5 |   |*|*|
*  4 |   |*|*|  _
*  3 |_  |*|*|_| |
*  2 | |_|*|*| | |
*  1 |_|_|*|*|_|_|________
*
*    请完成函数int largestRectangleArea(vector<int> &height)，实现寻找直方图中面积最大的矩形的功能，
* 如当给定直方图各小块的高度= [2,1,5,6,2,3] ，返回10。
* */
public class Histogram {

    private static final int HEIGHT = 1;
    private final int[] widths;

    public Histogram(int... widths) {
        this.widths = widths;
    }

    public int getMaxArea() {
        return widths[0] * HEIGHT;
    }
}
