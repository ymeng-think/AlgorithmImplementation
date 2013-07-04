package tw.ymeng.algorithm.proposition.array.sorting.generics;

import org.junit.Test;
import tw.ymeng.algorithm.proposition.array.sorting.comparator.CharacterComparator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class QuickSortTest {

    @Test
    public void should_sort_char_arrays() {
        Character[] chars = {'5', '3', 'a', '0', 'Z', 'z', '!'};
        QuickSort<Character> algorithm = new QuickSort<Character>(chars, new CharacterComparator());

        Character[] sorted = algorithm.sort();


        assertThat(sorted, is(new Character[]{'!', '0', '3', '5', 'Z', 'a', 'z'}));
    }
}
