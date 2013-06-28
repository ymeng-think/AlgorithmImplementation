package tw.ymeng.algorithm.interview.favorite_shopping;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;

public class FindingFavoriteItemTest {

    @Test
    public void should_get_none_when_no_customer_bought_specified_item() {
        FindingFavoriteItem findingFavoriteItem = new FindingFavoriteItem(
                new PurchasedRecordBuilder()
                        .record("custA", "item1")
                        .build());

        FavoriteItem item = findingFavoriteItem.findFirstBy("item2");

        assertSame("None", item.toString());
    }

    @Test
    public void should_get_none_when_all_the_customers_who_brought_item_x_only_bought_item_x() {
        FindingFavoriteItem findingFavoriteItem = new FindingFavoriteItem(
                new PurchasedRecordBuilder()
                        .record("custA", "item1")
                        .build());

        FavoriteItem item = findingFavoriteItem.findFirstBy("item1");

        assertSame("None", item.toString());
    }

    @Test
    public void should_find_out_what_else_was_bought_mostly_by_the_customers_who_bought_item_X() {
        FindingFavoriteItem findingFavoriteItem = new FindingFavoriteItem(
                new PurchasedRecordBuilder()
                        .record("custA", "item1")
                        .record("custB", "item1")
                        .record("custA", "item2")
                        .record("custB", "item3")
                        .record("custC", "item1")
                        .record("custC", "item3")
                        .record("custD", "item2")
                        .build());

        FavoriteItem item = findingFavoriteItem.findFirstBy("item1");

        assertSame("item3", item.toString());
    }

    @Test
    public void should_return_any_one_when_there_are_many_other_mostly_bought_items_which_have_equally_bought_times() {
        FindingFavoriteItem findingFavoriteItem = new FindingFavoriteItem(
                new PurchasedRecordBuilder()
                        .record("custA", "item1")
                        .record("custB", "item1")
                        .record("custC", "item1")
                        .record("custA", "item2")
                        .record("custB", "item3")
                        .record("custA", "item3")
                        .build());

        FavoriteItem[] items = findingFavoriteItem.findBy("item2");

        assertEquals(2, items.length);
        assertSame("item1", items[0].toString());
        assertSame("item3", items[1].toString());
    }
}