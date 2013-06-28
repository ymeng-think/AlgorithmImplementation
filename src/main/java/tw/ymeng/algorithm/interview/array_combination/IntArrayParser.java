package tw.ymeng.algorithm.interview.array_combination;

public class IntArrayParser {

    public int[] parse(String text) {
        String[] tokens = text.split("\\s+");
        int[] array = new int[tokens.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(tokens[i]);
        }

        return array;
    }
}
