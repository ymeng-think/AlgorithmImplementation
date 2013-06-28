package tw.ymeng.algorithm.interview.favoriteshopping;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RecordParserTest {

    @Test
    public void should_parse_to_purchased_record() {
        String text = "custA item1 custB item2";
        RecordParser parser = new RecordParser(text);

        PurchasedRecord record = parser.parse();

        PurchasedRecord expectedRecord = new PurchasedRecordBuilder()
                                            .record("custA", "item1")
                                            .record("custB", "item2")
                                            .build();
        assertEquals(expectedRecord, record);
    }

    @Test
    public void should_pass_for_input1() {
        String text = "custA item1 custB item2";
        RecordParser parser = new RecordParser(text);

        PurchasedRecord record = parser.parse();

        PurchasedRecord expectedRecord = new PurchasedRecordBuilder()
                .record("custA", "item1")
                .record("custB", "item2")
                .build();
        assertEquals(expectedRecord, record);
    }

}
