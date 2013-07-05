package tw.ymeng.algorithm.interview.permutation;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static tw.ymeng.algorithm.interview.permutation.Permutation.permutationWithIteration;
import static tw.ymeng.algorithm.interview.permutation.Permutation.permutationWithRecursion;
import static tw.ymeng.algorithm.interview.permutation.PermutationContainsMatcher.contains;

public class PermutationTest {

    @Test
    public void should_permutate_whole_word_that_does_NOT_contain_duplicated_characters_through_recursive_permutation() {
        Permutation permutation = permutationWithRecursion();

        permutation.permutate("abc", 0, 3);

        assertThat(permutation.allVarients(), contains(new String[]{"abc", "acb", "bca", "bac", "cab", "cba"}));
    }

    @Test
    public void should_permutate_partial_word_that_does_NOT_contain_duplicated_characters_through_recursive_permutation() {
        Permutation permutation = permutationWithRecursion();

        permutation.permutate("abcd", 1, 3);

        assertThat(permutation.allVarients(), contains(new String[]{"bcd", "bdc", "cbd", "cdb", "dcb", "dbc"}));
    }

    @Test
    public void should_permutate_word_that_contains_duplicated_characters_through_recursive_permutation() {
        Permutation permutation = permutationWithRecursion();

        permutation.permutate("abb", 0, 3);

        assertThat(permutation.allVarients(), contains(new String[]{"abb", "bab", "bba"}));
    }

    @Test
    public void should_permutate_whole_word_that_does_NOT_contain_duplicated_characters_through_iterative_permutation() {
        Permutation permutation = permutationWithIteration();

        permutation.permutate("abc", 0, 3);

        assertThat(permutation.allVarients(), contains(new String[]{"abc", "acb", "bca", "bac", "cab", "cba"}));
    }

    @Test
    public void should_permutate_partial_word_that_does_NOT_contain_duplicated_characters_through_iterative_permutation() {
        Permutation permutation = permutationWithIteration();

        permutation.permutate("abcd", 1, 3);

        assertThat(permutation.allVarients(), contains(new String[]{"bcd", "bdc", "cbd", "cdb", "dcb", "dbc"}));
    }

    @Test
    public void should_permutate_word_that_contains_duplicated_characters_through_iterative_permutation() {
        Permutation permutation = permutationWithIteration();

        permutation.permutate("abb", 0, 3);

        assertThat(permutation.allVarients(), contains(new String[]{"abb", "bab", "bba"}));
    }
}
