package tw.ymeng.algorithm.proposition.array.sorting;

/**
 * 快速排序
 *
 * Algorithm Time Complexity = O(n^2)

快速排序是C.R.A.Hoare于1962年提出的一种划分交换排序。它采用了一种分治的策略，通常称其为分治法(Divide-and-Conquer Method)。

 （1） 分治法的基本思想
 　    将原问题分解为若干个规模更小但结构与原问题相似的子问题。递归地解这些子问题，然后将这些子问题的解组合为原问题的解。

 （2）快速排序的基本思想
 　  设当前待排序的无序区为R[low..high]，利用分治法可将快速排序的基本思想描述为：
    ① 分解：
 　      在R[low..high]中任选一个记录作为基准(Pivot)，以此基准将当前无序区划分为左、右两个较小的子区间R[low..pivotpos-1)和
         R[pivotpos+1..high]，并使左边子区间中所有记录的关键字均小于等于基准记录(不妨记为pivot)的关键字pivot.key，右边的子区间中所
         有记录的关键字均大于等于pivot.key，而基准记录pivot则位于正确的位置(pivotpos)上，它无须参加后续的排序。
      注意：
 　      划分的关键是要求出基准记录所在的位置pivotpos。划分的结果可以简单地表示为(注意pivot=R[pivotpos])：
         R[low..pivotpos-1].keys≤R[pivotpos].key≤R[pivotpos+1..high].keys
      其中low≤pivotpos≤high。
    ② 求解：
 　    通过递归调用快速排序对左、右子区间R[low..pivotpos-1]和R[pivotpos+1..high]快速排序。
    ③ 组合：
 　    因为当"求解"步骤中的两个递归调用结束时，其左、右两个子区间已有序。对快速排序而言，"组合"步骤无须做什么，可看作是空操作。

 (3) 一趟快速排序的算法是：
    1）设置两个变量i、j，排序开始的时候：i=0，j=N-1；
    2）以第一个数组元素作为关键数据，赋值给key，即 key=A[0]；
    3）从j开始向前搜索，即由后开始向前搜索（j -- ），找到第一个小于key的值A[j]，A[i]与A[j]交换；
    4）从i开始向后搜索，即由前开始向后搜索（i ++ ），找到第一个大于key的A[i]，A[i]与A[j]交换；
    5）重复第3、4、5步，直到 I=J； (3,4步是在程序中没找到时候j=j-1，i=i+1，直至找到为止。找到并交换的时候i， j指针位置不变。另外当i=j
       这过程一定正好是i+或j-完成的最后令循环结束。）
 *
 */
public class QuickSort implements Sort {

    private int[] items;

    public QuickSort(int[] items) {
        this.items = items;
    }

    @Override
    public int[] sort() {
        return sort(0, items.length - 1);
    }

    private int[] sort(int start, int end) {
        if (start < end) {
            int pivot = partition(start, end);
            sort(start, pivot - 1);
            sort(pivot + 1, end);
        }

        return items;
    }

    private int partition(int start, int end) {
        int i = start, j = end;
        int pivotKey = items[start];

        while (i < j) {
            while (i < j && items[j] >= pivotKey) {
                j--;
            }
            items[i] = items[j];

            while (i < j && items[i] <= pivotKey) {
                i++;
            }
            items[j] = items[i];
        }

        items[i] = pivotKey;

        return i;
    }
}
