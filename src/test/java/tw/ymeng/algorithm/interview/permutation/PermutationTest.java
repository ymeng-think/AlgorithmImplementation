package tw.ymeng.algorithm.interview.permutation;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static tw.ymeng.algorithm.interview.permutation.PermutationContainsMatcher.contains;

public class PermutationTest {

    @Test
    public void should_permutate_whole_word_that_does_not_contain_duplicated_characters() {
        Permutation permutation = Permutation.PermutationWithoutDuplicates;

        permutation.permutate("abc", 0, 3);

        assertThat(permutation.allVarients(), contains(new String[]{"abc", "acb", "bca", "bac", "cab", "cba"}));
    }
}
