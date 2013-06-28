package tw.ymeng.algorithm.interview.favoriteshopping;

public class RecordParser {

    private String text;

    public RecordParser(String text) {
        this.text = text;
    }

    public PurchasedRecord parse() {
        String[] tokens = text.split("\\s+");
        PurchasedRecord record = new PurchasedRecord();

        for (int i = 0; i < tokens.length; i += 2) {
            record.add(tokens[i], tokens[i + 1]);
        }

        return record;
    }
}
