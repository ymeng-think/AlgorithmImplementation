package tw.ymeng.algorithm.interview.permutation.strategy;

import tw.ymeng.algorithm.interview.permutation.PermutationStrategy;
import tw.ymeng.algorithm.interview.permutation.Recorder;

public class AllPermutationWithoutDuplicates implements PermutationStrategy {

    private Recorder recorder;

    public AllPermutationWithoutDuplicates() {
        this.recorder = new LazyRecorder();
    }

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
            swap(chars, start, i);
            permutate(chars, start + 1 , end);
            swap(chars, start, i);
        }
    }

    private void swap(char[] chars, int index1, int index2) {
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }
}
