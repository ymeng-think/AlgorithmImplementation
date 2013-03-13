package tw.ymeng.algorithm.sorting;

import static tw.ymeng.algorithm.sorting.util.Swapper.swap;

/*
* 堆排序
*
* Algorithm Time Complexity = O(n)

堆排序其实最主要的两个过程：第一步，创建初始堆；第二步，交换根节点与最后一个非叶子节

第一步实现 ：从最后一个非叶子节点为开始向前循环每个分支节点，比较每个分支节点与他左右子节点，如果其中某个子节点比父节点大，则与父节点交换，
交换后原父节点可能还小于原子节点的子节点，所以还需对原父节点进行调整，使用原父节点继续下沉，直到没有子节点或比左右子节点都大为止，调用过程
可通过递归完成。当某个非叶子节点调整完毕后，再处理下一个非叶子节点，直到根节点也调整完成，这里初始堆就创建好了，这里我们创建的是大顶堆，即
大的元素向树的根浮，这样排序最后得到的结果为升序，因为最大的从树中去掉，并从数组最后往前存放。

第二步实现 ：将树中的最后一个元素与堆顶元素进行交换，并从树中去掉最后叶子节点。交换后再按创建初始堆的算法调整根节点，如此下去直到树中只有
一个节点为止。
*
**/
public class HeapSort implements Sort {

    private int[] items;

    public HeapSort(int[] items) {
        this.items = items;
    }

    @Override
    public int[] sort() {
        return sort(0, items.length - 1);
    }

    private int[] sort(int start, int end) {
        initHeap(start, end);

        for (int i = end - start + 1; i >= 2; i--) {
            swap(items, start, i - 1);
            adjustNode(1, i - 1);
        }

        return items;
    }

    private void initHeap(int start, int end) {
        int lastBranchNodeIndex = (end - start + 1) / 2;
        for (int i = lastBranchNodeIndex; i >= 1; i--) {
            adjustNode(i, end - start + 1);
        }
    }

    private void adjustNode(int parentNodeIndex, int length) {
        int minNodeIndex = parentNodeIndex;

        if (hasLeftSubTree(parentNodeIndex, length)) {
            if (items[parentNodeIndex - 1] < items[leftSubNodeIndex(parentNodeIndex)]) {
                minNodeIndex = parentNodeIndex * 2;
            }

            if (hasRightSubTree(parentNodeIndex, length)) {
                if (items[minNodeIndex - 1] < items[rightSubNodeIndex(parentNodeIndex)]) {
                    minNodeIndex = parentNodeIndex * 2 + 1;
                }
            }
        }

        if (minNodeIndex != parentNodeIndex) {
            swap(items, parentNodeIndex - 1, minNodeIndex - 1);
            if (minNodeIndex * 2 <= length) {
                adjustNode(minNodeIndex, length);
            }
        }
    }

    private static int rightSubNodeIndex(int parentNodeIndex) {
        return parentNodeIndex * 2;
    }

    private static int leftSubNodeIndex(int parentNodeIndex) {
        return parentNodeIndex * 2 - 1;
    }

    private static boolean hasRightSubTree(int parentNodeIndex, int length) {
        return parentNodeIndex * 2 + 1 <= length;
    }

    private static boolean hasLeftSubTree(int parentNodeIndex, int length) {
        return parentNodeIndex * 2 <= length;
    }
}
