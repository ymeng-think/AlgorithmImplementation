package tw.ymeng.algorithm.interview.permutation;

import org.junit.Ignore;
import org.junit.Test;

public class PermutationTest {

    @Test
    @Ignore
    public void should_permutate_words_that_does_not_contains_duplicated_characters() {
        Permutation permutation = Permutation.PermutationWithoutDuplicates;

        permutation.permutate("abc", 0, 3);
    }
}
