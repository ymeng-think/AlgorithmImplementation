package tw.ymeng.algorithm.interview;

import tw.ymeng.algorithm.proposition.array.search.BinarySearch;

/**
 * 问题 (From Amazon)：
 *
 * 有一个循环有序数组A，如{7,8,9,0,1,2,3,4,5,6}，不知道其最小值的位置。
 * 那么如何从这样的数组中寻找一个特定的元素呢？
 *
 * 解决：
 *
 * 当然，遍历总是一个办法。当然面试的时候回答遍历估计就直接杯具了。
 * 我的想法是将原数组分段，用首元素s，中间元素m和尾元素e，可以将数组分为两个子数组s1，s2，
 * 那么，必然有至少一个子数组是有序的。那么如何确定那一段是有序的呢？
 *
 * 通过分析可以看到只有3种情况：
 *   ● 当s就是A中最小的元素时，以下不等式成立：
 *      s <= m <= e
 *   ● 当最小值位于(s, m]时，则有：
 *      m <= e <= s
 *   ● 当最小值出现在(m,e]时，则有：
 *      e <= s <= m
 * 所以通过s,m,e的大小关系，可以很轻松的判断出s1和s2哪个是有序的。
 * 通过比较要查找的目标t 与s,m,e的大小关系，可以知道t位于哪个子数组。
 * 若t位于有序的子数组，则用二分查找就可以了。
 * 否则，对无序的子数组重复刚才的过程就可以了。
 * */
public class LoopOrderedArray {

    private int[] array;

    public LoopOrderedArray(int[] array) {
        this.array = array;
    }

    public int find(int target) {
        return find(target, 0, array.length - 1);
    }

    private int find(int target, int start, int end) {
        if(start > end){
            return -1;
        }

        int mid = start + (end - start) / 2;
        int startValue  = array[start];
        int middleValue = array[mid];
        int endValue    = array[end];

        if(startValue <= middleValue) {
            if (startValue <= endValue) {                               // mini value is at start
                return binarySearch(array, target, start, end);
            } else {                                                    // mini value is in range (mid, end]
                if(target >= startValue && target <= middleValue) {
                    return binarySearch(array, target, start, mid);
                } else {
                    return find(target, mid + 1, end);
                }
            }
        } else {                                                        // mini value is in range (start, mid]
            if(target > middleValue && target <= endValue) {
                return binarySearch(array, target, mid + 1, end);
            } else {
                return find(target, start, mid);
            }
        }
    }

    private int binarySearch(int[] array, int target, int start, int end) {
        return new BinarySearch(array).searchInRange(target, start, end);
    }
}
