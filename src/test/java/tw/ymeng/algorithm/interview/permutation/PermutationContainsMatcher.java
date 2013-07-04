package tw.ymeng.algorithm.interview.permutation;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PermutationContainsMatcher extends TypeSafeMatcher<String[]> {

    private String[] expected;

    public PermutationContainsMatcher(String[] expected) {
        this.expected = expected;
    }

    @Override
    protected boolean matchesSafely(String[] actual) {
        Set<String> actualWords = convertToSet(actual);

        if (actualWords.size() != actual.length || actualWords.size() != expected.length) {
            return false;
        }

        for (String expectedWord : expected) {
            if (!actualWords.contains(expectedWord)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Contains permutations: ").appendValue(expected);
    }

    private Set<String> convertToSet(String[] actual) {
        Set<String> actualWords = new HashSet<String>();
        Collections.addAll(actualWords, actual);
        return actualWords;
    }

    public static Matcher<String[]> contains(String[] expected) {
        return new PermutationContainsMatcher(expected);
    }
}
