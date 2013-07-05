package tw.ymeng.algorithm.interview.permutation.strategy;

import tw.ymeng.algorithm.interview.permutation.PermutationStrategy;
import tw.ymeng.algorithm.interview.permutation.Recorder;

import static tw.ymeng.algorithm.utils.Swapper.swap;

public class RecursiveAllPermutation implements PermutationStrategy {

    private Recorder recorder;

    public RecursiveAllPermutation() {
        this.recorder = new LazyRecorder();
    }

    /**
     * 为方便起见，用123来示例下。123的全排列有123、132、213、231、312、321这六种。首先考虑213和321这二个数是如何得出的。
     * 显然这二个都是123中的1与后面两数交换得到的。然后可以将123的第二个数和每三个数交换得到132。同理可以根据213和321来得231和312。
     * 因此可以知道——全排列就是从第一个数字起每个数分别与它后面的数字交换。
     *
     * 去掉重复的全排列:
     * 对122，第一个数1与第二个数2交换得到212，然后考虑第一个数1与第三个数2交换，此时由于第三个数等于第二个数，
     * 所以第一个数不再与第三个数交换。再考虑212，它的第二个数与第三个数交换可以得到解决221。此时全排列生成完毕。
     * */
    @Override
    public void permutate(String word, int start, int length) {
        for (int i = start, end = start + length - 1; end < word.length(); i++, end = i + length - 1) {
            String subWord = word.substring(i, end + 1);
            char[] chars = subWord.toCharArray();
            permutate(chars, 0, chars.length - 1);
        }
    }

    @Override
    public void setRecorder(Recorder recorder) {
        this.recorder = recorder;
    }

    private void permutate(char[] chars, int start, int end) {
        if (start == end) {
            recorder.record(String.valueOf(chars));
            return;
        }

        for(int i = start; i <= end; i++) {
            if (!needsToSwap(chars, start, i)) {
                continue;
            }
            swap(chars, start, i);
            permutate(chars, start + 1 , end);
            swap(chars, start, i);
        }
    }

    private boolean needsToSwap(char[] chars, int start, int next) {
        for (int i = start; i < next; i++) {
            if (chars[i] == chars[next]) {
                return false;
            }
        }
        return true;
    }

}
