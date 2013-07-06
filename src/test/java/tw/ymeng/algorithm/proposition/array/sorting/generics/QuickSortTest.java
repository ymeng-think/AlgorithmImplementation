package tw.ymeng.algorithm.proposition.array.sorting.generics;

import org.junit.Test;
import tw.ymeng.algorithm.proposition.array.sorting.comparator.CharacterComparator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static tw.ymeng.algorithm.proposition.array.sorting.generics.QuickSort.qsort;

public class QuickSortTest {

    @Test
    public void should_sort_char_arrays() {
        Character[] chars = {'5', '3', 'a', '0', 'Z', 'z', '!'};

        Character[] sorted = qsort(chars, new CharacterComparator());

        assertThat(sorted, is(new Character[]{'!', '0', '3', '5', 'Z', 'a', 'z'}));
    }
}
