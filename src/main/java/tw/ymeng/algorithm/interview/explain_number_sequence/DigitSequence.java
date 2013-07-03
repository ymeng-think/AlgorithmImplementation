package tw.ymeng.algorithm.interview.explain_number_sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DigitSequence {

    private Map<Character, Integer> sequence = new HashMap<Character, Integer>();
    private List<Character> order = new ArrayList<Character>();

    public DigitSequence add(char digit) {
        if (!sequence.containsKey(digit)) {
            sequence.put(digit, 1);
        } else {
            int counter = sequence.get(digit);
            sequence.put(digit, counter + 1);
        }
        order.add(digit);

        return this;
    }

    public int count(char digit) {
        return sequence.get(digit);
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();

        for (char digit : order) {
            text.append(digit).append(sequence.get(digit));
        }

        return text.toString();
    }
}
