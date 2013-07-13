package tw.ymeng.algorithm.interview;

/**
 * Question (find out the label of Excel column)
 *
 * Excel columns are labelled alphabetically in length-lexicographic order i.e., A, B, C, ..., Z,
 *  AA, AB, ....，ZY,ZZ,AAA,AAB,...,ZAA,ZAB,....ZZZ,......
 *
 * Given the  index of a column, return the corresponding label.
 * Note: Let's aussme the column num of Excel does not exceed the max int.
 * Note: Adding some test cases in your code comments will get plus.
 *
 * Example 1:
 *   Input: 1
 *   Output: A
 *
 * Example 2:
 *   Input: 54
 *   Output: BB
 *
 * Example 3:
 *   Input: 10000
 *   Output: NTP
 * */
public class ExcelColumnFinder {

    private static final String[] LABELS = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "X", "Y", "Z"};
    private static final int ALPHA_COUNT = 26;

    public String find(int columnIndex) {
        StringBuilder buffer = new StringBuilder();
        find(buffer, columnIndex);

        return buffer.toString();
    }

    public void find(StringBuilder buffer, int columnIndex) {
        if (columnIndex <= ALPHA_COUNT) {
            buffer.append(LABELS[columnIndex]);
            return;
        }

        find(buffer, columnIndex / ALPHA_COUNT);
        buffer.append(LABELS[columnIndex % ALPHA_COUNT]);
    }
}
