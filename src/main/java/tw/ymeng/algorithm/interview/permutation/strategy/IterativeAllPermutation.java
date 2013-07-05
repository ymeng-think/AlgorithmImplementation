package tw.ymeng.algorithm.interview.permutation.strategy;

import tw.ymeng.algorithm.interview.permutation.PermutationStrategy;
import tw.ymeng.algorithm.interview.permutation.Recorder;
import tw.ymeng.algorithm.proposition.array.sorting.comparator.CharacterComparator;
import tw.ymeng.algorithm.proposition.array.sorting.generics.QuickSort;

import static tw.ymeng.algorithm.proposition.array.sorting.generics.Swapper.swap;

public class IterativeAllPermutation implements PermutationStrategy {

    private Recorder recorder;

    public IterativeAllPermutation() {
        this.recorder = new LazyRecorder();
    }

    /**
     * 要考虑全排列的非递归实现，先来考虑如何计算字符串的下一个排列。如"1234"的下一个排列就是"1243"。只要对字符串反复求出下一个排列，
     * 全排列的也就迎刃而解了。
     * 如何计算字符串的下一个排列了？来考虑"926520"这个字符串，我们从后向前找第一双相邻的递增数字，"20"、"52"
     * 都是非递增的，"26 "即满足要求，称前一个数字2为替换数，替换数的下标称为替换点，再从后面找一个比替换数大的最小数（这个数必然存在），
     * 0、2都不行，5可以，将5和2交换得到"956220"，然后再将替换点后的字符串"6220"颠倒即得到"950226"。
     * 对于像“4321”这种已经是最“大”的排列，采用STL中的处理方法，将字符串整个颠倒得到最“小”的排列"1234"并返回false。
     *
     * 这样，只要一个循环再加上计算字符串下一个排列的函数就可以轻松的实现非递归的全排列算法。
     * */
    @Override
    public void permutate(String word, int start, int length) {
        for (int i = start, end = start + length - 1; end < word.length(); i++, end = i + length - 1) {
            String subWord = word.substring(i, end + 1);
            Character[] chars = toCharacterArray(subWord);
            permutate(chars);
        }
    }

    @Override
    public void setRecorder(Recorder recorder) {
        this.recorder = recorder;
    }

    private Character[] toCharacterArray(String word) {
        Character[] chars = new Character[word.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = word.charAt(i);
        }

        return chars;
    }

    private void permutate(Character[] chars) {
        QuickSort<Character> quickSort = new QuickSort(chars, new CharacterComparator());
        Character[] sorted = quickSort.sort();

        do {
            recorder.record(convertToString(sorted));
        } while(nextPermutation(sorted));
    }

    private String convertToString(Character[] chars) {
        StringBuilder text = new StringBuilder();
        for (Character c : chars) {
            text.append(c);
        }
        return text.toString();
    }

    private boolean nextPermutation(Character[] chars) {
        if (chars.length == 1) {
            return false;
        }

        int end = chars.length - 1;
        int p = end;
        while (p != 0) {
            int q = p;
            p--;
            if (chars[p] < chars[q]) {              // 找降序的相邻2数，前一个数即替换数
                int find = end;                     // 从后向前找比替换点大的第一个数
                while (chars[find] < chars[p]) {
                    find--;
                }

                swap(chars, p, find);
                reverse(chars, q, end);             // 替换点后的数全部反转
                return true;
            }
        }
        reverse(chars, 0, end);                     // 如果没有下一个排列，全部反转后返回false

        return false;
    }

    private void reverse(Character[] chars, int start, int end) {
        while(start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }
}
