package tw.ymeng.algorithm.interview.polygon_filling;

import tw.ymeng.algorithm.interview.polygon_filling.strategy.FillStrategy;
import tw.ymeng.algorithm.interview.polygon_filling.strategy.Point;

/**
 * 平面区域填充算法是计算机图形学领域的一个很重要的算法，区域填充即给出一个区域的边界（也可以是没有边界，只是给出指定颜色），
 * 要求将边界范围内的所有象素单元都修改成指定的颜色（也可能是图案填充）。区域填充中最常用的是多边形填色，本文中我们就讨论
 * 几种多边形区域填充算法。
 *
 * $$ 种子填充算法（Seed Filling） $$
 *
 * 如果要填充的区域是以图像元数据方式给出的，通常使用种子填充算法（Seed Filling）进行区域填充。种子填充算法需要给出图像数据的区域，
 * 以及区域内的一个点，这种算法比较适合人机交互方式进行的图像填充操作，不适合计算机自动处理和判断填色。根据对图像区域边界定义方式以及
 * 对点的颜色修改方式，种子填充又可细分为几类，比如注入填充算法（Flood Fill Algorithm）、边界填充算法（Boundary Fill Algorithm）
 * 以及为减少递归和压栈次数而改进的扫描线种子填充算法等等。
 * 所有种子填充算法的核心其实就是一个递归算法，都是从指定的种子点开始，向各个方向上搜索，逐个像素进行处理，直到遇到边界，各种种子填充算法
 * 只是在处理颜色和边界的方式上有所不同。在开始介绍种子填充算法之前，首先也介绍两个概念，就是“4-联通算法”和“8-联通算法”。既然是搜索就涉
 * 及到搜索的方向问题，从区域内任意一点出发，如果只是通过上、下、左、右四个方向搜索到达区域内的任意像素，则用这种方法填充的区域就称为四连
 * 通域，这种填充方法就称为“4-联通算法”。如果从区域内任意一点出发，通过上、下、左、右、左上、左下、右上和右下全部八个方向到达区域内的任
 * 意像素，则这种方法填充的区域就称为八连通域，这种填充方法就称为“8-联通算法”。如图1（a）所示，假设中心的蓝色点是当前处理的点，如果是
 * “4-联通算法”，则只搜索处理周围蓝色标识的四个点，如果是“8-联通算法”则除了处理上、下、左、右四个蓝色标识的点，还搜索处理四个红色标识的
 * 点。两种搜索算法的填充效果分别如如图1（b）和图1（c）所示，假如都是从黄色点开始填充，则“4-联通算法”如图1（b）所示只搜索填充左下角的区
 * 域，而“8-联通算法”则如图1（c）所示，将左下角和右上角的区域都填充了。
 *
 * 图－1 (a)
 *               X---O---X
 *               |   |   |
 *               O---O---O
 *               |   |   |
 *               X---O---X
 *
 * 图－1 (b) ”4-联通” 填充效果   Note: @为起点
 *                 X X X X X
 *                 X       X
 *               X X       X
 *           X X X O X X X X
 *           X O O O X
 *           X O @ O X
 *           X X X X X
 *
 * 图－1 (c) “8-联通” 填充效果
 *                 X X X X X
 *                 X O O O X
 *               X X O O O X
 *           X X X O X X X X
 *           X O O O X
 *           X O @ O X
 *           X X X X X
 *
 * 并不能仅仅因为图1的填充效果就认为“8-联通算法”一定比“4-联通算法”好，应该根据应用环境和实际的需求选择联通搜索方式，在很多情况下，
 * 只有“4-联通算法”才能得到正确的结果。
 * */
public class Polygon {

    private char[][] graph;

    public Polygon(char[][] graph) {
        this.graph = graph;
    }

    public char[][] fill(FillStrategy strategy, int x, int y, char newValue) {
        strategy.setGraph(graph);
        return strategy.fill(new Point(x, y), getOldValue(x, y), newValue);
    }

    private char getOldValue(int x, int y) {
        return graph[x][y];
    }
}
