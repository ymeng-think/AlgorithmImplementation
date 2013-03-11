package tw.ymeng.algorithm.sorting;

/*
*
*  希尔思想介绍

希尔算法的本质是缩小增量排序，是对直接插入排序算法的改进。一般直接插入排序的时间复杂度为O ( n^2 ) ，但是当数列基本有序时，如果按照有数列
顺序排时，时间复杂度将改善到O( n )，另外,因直接插入排序算法简单,如果待排序列规模不很大时效率也较高，Shell 根据这两点分析结果进行了改进，
将待排记录序列以一定的增量间隔h 分割成多个子序列，对每个子序列分别进行一趟直接插入排序, 然后逐步减小分组的步长h ，对于每一个步长h 下的各个
子序列进行同样方法的排序,直到步长为1 时再进行一次整体排序。
因为不管记录序列多么庞大,关键字多么混乱,在先前较大的分组步长h 下每个子序列的规模都不大，用直接插入排序效率都较高。 尽管在随后的步长h 递减
分组中子序列越来越大，但由于整个序列的有序性也越来越明显，则排序效率依然较高。这种改进抓住了直接插入排序的两点本质，大大提高了它的时间效率。

希尔增量研究

综上所述：

(1) 希尔排序的核心是以某个增量h 为步长跳跃分组进行插入排序，由于分组的步长h 逐步缩小，所以也叫“缩小增量排序”插入排序。其关键是如何选取分
    组的步长序列ht ,. . . , hk ,. . . , h1 , h0 才能使得希尔方法的时间效率最高；

(2) 待排序列记录的个数n 、跳跃分组步长逐步减小直到为1时所进行的扫描次数T、增量的和、记录关键字比较的次数以及记录移动的次数或各子序列中的
    反序数等因素都影响希尔算法的时间复杂度：其中记录关键字比较的次数是重要因素，它主要取决于分组步长序列的选择；

(3) 希尔方法是一种不稳定排序算法，因为其排序过程中各趟的步长不同，在第k 遍用hk作为步长排序之后，第k +1 遍排序时可能会遇到多个逆序存在，
    影响排序的稳定性。

试验结果表明,SHELL 算法的时间复杂度受增量序列的影响明显大于其他因素，选取恰当的增量序列能明显提高排序的时间效率，我们认为第k 趟排序扫描的
增量步长为 2^k - 1 ,即增量序列为. . . 2^k - 1 ,. . . ,15 ,7 ,3 ,1时较为理想，但它并不是唯一的最佳增量序列，这与其关联函数目前尚无确
定解的理论结果是一致的。
*
* */
public class ShellSort {
    public static int[] sort(int[] items) {
        return sort(items, 0, items.length - 1);
    }

    private static int[] sort(int[] items, int start, int end) {
        for (int step = initStep(start, end); step >= 1; step = (step + 1) / 2 - 1) {
            for (int groupIndex = 0; groupIndex < step; groupIndex++) {
                insertSort(items, groupIndex, step, end);
            }
        }

        return items;
    }

    private static void insertSort(int[] items, int groupIndex, int step, int terminal) {
        int start = groupIndex;
        int end = start;

        while ((end + step) <= terminal) {
            end += step;
        }

        for (int i = groupIndex + step; i <= terminal; i += step) {
            for (int j = groupIndex; j < i; j += step) {
                int insertedItem = items[i];
                if (insertedItem < items[j]) {
                    Mover.move(items, j, i - step, step);
                    items[j] = insertedItem;
                    break;
                }
            }
        }

    }

    private static int initStep(int start, int end) {
        int length = end - start + 1;
        int step = 1;

        while ((step + 1) * 2 - 1 < length - 1) {
            step = (step + 1) * 2 - 1;
        }

        return step;
    }
}
