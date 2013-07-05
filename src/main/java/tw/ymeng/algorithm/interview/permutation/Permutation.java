package tw.ymeng.algorithm.interview.permutation;

import tw.ymeng.algorithm.interview.permutation.strategy.IterativeAllPermutation;
import tw.ymeng.algorithm.interview.permutation.strategy.RecursiveAllPermutation;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列在笔试面试中很热门，因为它难度适中，既可以考察递归实现，又能进一步考察非递归的实现，便于区分出考生的水平。
 * 所以在百度和迅雷的校园招聘以及程序员和软件设计师的考试中都考到了，因此本文对全排列作下总结帮助大家更好的学习和理解。
 *
 * 如 abc 的全排列: abc, acb, bca, dac, cab, cba
 * */
public class Permutation implements Recorder {

    private PermutationStrategy strategy;
    private List<String> words = new ArrayList<String>();

    private Permutation(PermutationStrategy strategy) {
        this.strategy = strategy;
    }

    public static Permutation permutationWithRecursion() {
        return new Permutation(new RecursiveAllPermutation());
    }

    public static Permutation permutationWithIteration() {
        return new Permutation(new IterativeAllPermutation());
    }

    public void permutate(String word, int start, int length) {
        strategy.setRecorder(this);
        strategy.permutate(word, start, length);
    }

    @Override
    public void record(String word) {
        words.add(word);
    }

    public String[] allVarients() {
        return words.toArray(new String[0]);
    }
}
