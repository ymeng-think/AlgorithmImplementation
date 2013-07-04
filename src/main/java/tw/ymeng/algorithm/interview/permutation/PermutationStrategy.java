package tw.ymeng.algorithm.interview.permutation;

public interface PermutationStrategy {

    void permutate(String word, int start, int length);

    void setRecorder(Recorder recorder);
}
