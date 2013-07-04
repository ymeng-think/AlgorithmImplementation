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

    }

    @Override
    public void setRecorder(Recorder recorder) {
        this.recorder = recorder;
    }
}
