package tw.ymeng.algorithm.interview.product_of_elements;

public class ElementArray {

    private int except;
    private long productOfOthers;

    public ElementArray(int except, long productOfOthers) {
        this.except = except;
        this.productOfOthers = productOfOthers;
    }

    public int except() {
        return except;
    }

    public long productOfOthers() {
        return productOfOthers;
    }
}
