package tw.ymeng.algorithm.interview.permutation;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static tw.ymeng.algorithm.interview.permutation.Permutation.permutationWithoutDuplicates;
import static tw.ymeng.algorithm.interview.permutation.PermutationContainsMatcher.contains;

public class PermutationTest {

    @Test
    public void should_permutate_whole_word_that_does_NOT_contain_duplicated_characters() {
        Permutation permutation = permutationWithoutDuplicates();

        permutation.permutate("abc", 0, 3);

        assertThat(permutation.allVarients(), contains(new String[]{"abc", "acb", "bca", "bac", "cab", "cba"}));
    }

    @Test
    public void should_permutate_partial_word_that_does_NOT_contain_duplicated_characters() {
        Permutation permutation = permutationWithoutDuplicates();

        permutation.permutate("abcd", 1, 3);

        assertThat(permutation.allVarients(), contains(new String[]{"bcd", "bdc", "cbd", "cdb", "dcb", "dbc"}));
    }
}
