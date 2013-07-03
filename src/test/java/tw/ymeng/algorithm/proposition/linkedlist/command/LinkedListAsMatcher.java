package tw.ymeng.algorithm.proposition.linkedlist.command;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import tw.ymeng.algorithm.proposition.linkedlist.LinkedList;

public class LinkedListAsMatcher extends TypeSafeMatcher<LinkedList> {

    private int[] expectedIntArray;

    public LinkedListAsMatcher(int[] expected) {
        this.expectedIntArray = expected;
    }

    @Override
    protected boolean matchesSafely(LinkedList actual) {
        int index = 0;
        LinkedList head = actual;

        while (head != null) {
            if (head.data() != expectedIntArray[index]) {
                return false;
            }

            head = head.next();
            index++;
        }

        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(expectedIntArray);
    }

    @Factory
    public static Matcher<LinkedList> as(int... expected) {
        return new LinkedListAsMatcher(expected);
    }
}
