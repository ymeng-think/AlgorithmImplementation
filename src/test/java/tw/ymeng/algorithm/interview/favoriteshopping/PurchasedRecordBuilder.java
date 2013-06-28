package tw.ymeng.algorithm.interview.favoriteshopping;

public class PurchasedRecordBuilder {

    private final PurchasedRecord record;

    public PurchasedRecordBuilder() {
        record = new PurchasedRecord();
    }

    public PurchasedRecordBuilder record(String customerID, String itemID) {
        record.add(customerID, itemID);
        return this;
    }

    public PurchasedRecord build() {
        return record;
    }
}
