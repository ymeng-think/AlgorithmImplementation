package tw.ymeng.algorithm.interview.favoriteshopping;


/***********************************************************************************************************************
 Question (From Amazon):

 We have an array representing customer’s shopping records.
 For example, it’s an array like this:
 custA, item1,
 custB, item1,
 custA, item2,
 custB, item3,
 custC, item1,
 custC, item3,
 custD, item2,
 This array indicates that customer A bought item 1, customer B bought item 1, customer A bought item 2, customer B bought
 item 3, etc..
 For a given item X and shopping records array, write code to find out what else (item Y) was bought mostly by the customers
 who bought item X.
 For example, in above example, if X is item 1 then Y should be item 3.

 Rules:
 1.  One customer can only buy one item once.
 2.  The mostly bought item should not be item X.
 3.  If no customer bought item X, then return “None”
 4.  If all the customers who brought item X only bought item X, then return “None”
 5.  The first line of input is the item X. The second line of input is the shopping record array, this shopping record array is
 split by space.
 6.  If there are many other mostly brought items which have equally brought times, then return any one of those items.

 Examples:
 Input1:
 item1
 custA item1 custB item1 custA item2 custB item3 custC item1 custC item3 custD item2
 Output1:
 item3

 Input2:
 item2
 custA item1 custB item1 custC item1 custA item2 custB item3 custA item3
 Output2:
 item1
 (The output2 can be item3 too)
 ***********************************************************************************************************************/
public class FindingFavoriteItem {

    private PurchasedRecord record;

    public FindingFavoriteItem(PurchasedRecord record) {
        this.record = record;
    }


    public FavoriteItem findFirstBy(String itemID) {
        return findBy(itemID)[0];
    }

    public FavoriteItem[] findBy(String itemID) {
        if (!record.hasPurchasedItem(itemID)) {
            return noneArray();
        }

        if (record.onlyPurchaseditem(itemID)) {
            return noneArray();
        }

        return createFavoriteItems(record.findMostlyPurchasedItemID(itemID));
    }

    private FavoriteItem[] createFavoriteItems(String[] mostlyPurchasedItemIDs) {
        FavoriteItem[] items = new FavoriteItem[mostlyPurchasedItemIDs.length];
        for(int i = 0; i < items.length; i++) {
            items[i] = new FavoriteItem(mostlyPurchasedItemIDs[i]);
        }
        return items;
    }

    private FavoriteItem[] noneArray() {
        return new FavoriteItem[] {FavoriteItem.None};
    }
}