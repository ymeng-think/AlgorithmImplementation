package tw.ymeng.algorithm.interview.favorite_shopping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class PurchasedRecord {

    private final HashMap<String,ArrayList<String>> purchasedBy;

    public PurchasedRecord() {
        purchasedBy = new HashMap<String, ArrayList<String>>();
    }

    public void add(String customerID, String itemID) {
        if (!purchasedBy.containsKey(itemID)) {
            purchasedBy.put(itemID, new ArrayList<String>());
        }

        ArrayList<String> items = purchasedBy.get(itemID);
        items.add(customerID);
    }

    public boolean hasPurchasedItem(String itemID) {
        return purchasedBy.containsKey(itemID);
    }

    public boolean onlyPurchaseditem(String itemID) {
        ArrayList<String> customers = purchasedBy.get(itemID);

        Set<String> allItems = purchasedBy.keySet();
        for (String item : allItems) {
            if (item.equals(itemID)) {
                continue;
            }
            ArrayList<String> tempCustomers = purchasedBy.get(item);
            if (containsCustomer(tempCustomers, customers)) {
                return false;
            }
        }

        return true;
    }

    private boolean containsCustomer(ArrayList<String> customerArray1, ArrayList<String> customerArray2) {
        for (String customerID : customerArray2) {
            if (customerArray1.contains(customerID)) {
                return true;
            }
        }

        return false;
    }

    public String[] findMostlyPurchasedItemID(String itemID) {
        HashMap<String, Integer> purchasedOtherItems = new HashMap<String, Integer>();

        ArrayList<String> customers = purchasedBy.get(itemID);
        Set<String> allItems = purchasedBy.keySet();
        for (String item : allItems) {
            if (item.equals(itemID)) {
                continue;
            }
            ArrayList<String> tempCustomers = purchasedBy.get(item);
            for (String customerID : customers) {
                if (!tempCustomers.contains(customerID)) {
                    continue;
                }
                increaseCounter(purchasedOtherItems, item);
            }
        }


        String[] itemIDs = getItemPurchasedMostly(purchasedOtherItems);
        Arrays.sort(itemIDs);
        return itemIDs;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof PurchasedRecord)) {
            return false;
        }

        PurchasedRecord newRecord = (PurchasedRecord)o;

        if (purchasedBy.size() != newRecord.purchasedBy.size()) {
            return false;
        }

        if (!purchasedBy.keySet().equals(newRecord.purchasedBy.keySet())) {
            return false;
        }

        for (String key : purchasedBy.keySet()) {
            if (!purchasedBy.get(key).equals(newRecord.purchasedBy.get(key))) {
                return false;
            }
        }

        return true;
    }

    private String[] getItemPurchasedMostly(HashMap<String, Integer> purchasedItems) {
        Set<String> itemIDs = purchasedItems.keySet();
        ArrayList<String> returnItemIDs = new ArrayList<String>();
        int maxPurchasedTime = 0;

        for (String itemID : itemIDs) {
            int times = purchasedItems.get(itemID);
            if (times > maxPurchasedTime) {
                returnItemIDs.clear();
                returnItemIDs.add(itemID);
                maxPurchasedTime = times;
            } else if (times == maxPurchasedTime) {
                returnItemIDs.add(itemID);
            }
        }
        return returnItemIDs.toArray(new String[0]);
    }

    private void increaseCounter(HashMap<String, Integer> purchasedItems, String itemID) {
        if (!purchasedItems.containsKey(itemID)) {
            purchasedItems.put(itemID, 0);
        }

        Integer purchasedTimes = purchasedItems.get(itemID);
        purchasedItems.put(itemID, purchasedTimes + 1);
    }
}
