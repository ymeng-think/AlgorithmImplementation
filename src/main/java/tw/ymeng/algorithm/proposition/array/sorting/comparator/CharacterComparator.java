package tw.ymeng.algorithm.proposition.array.sorting.comparator;

import java.util.Comparator;

public class CharacterComparator implements Comparator<Character> {

    @Override
    public int compare(Character c1, Character c2) {
        return c1 - c2;
    }
}
