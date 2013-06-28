package tw.ymeng.algorithm.interview.favoriteshopping;

public class FavoriteItem {

    public static FavoriteItem None = new FavoriteItem("None");

    private String itemID;

    public FavoriteItem(String itemID) {
        this.itemID = itemID;
    }

    @Override
    public String toString() {
        return itemID;
    }
}
