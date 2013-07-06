package tw.ymeng.algorithm.interview.product_of_elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Question (From Amazon):
 *
 * 输入一个字符串包含一个整数数组，求数组里面每个元素除这个元素外的所有元素的乘积
 */
public class ProductOfElements {

    private int[] array;

    public ProductOfElements(int[] array) {
        this.array = array;
    }

    public List<ElementArray> calculate() {
        long product = calculateProductOfAllElements();
        List<ElementArray> result = new ArrayList<ElementArray>();

        for (int i : array) {
            result.add(new ElementArray(i, product / i));
        }

        return result;
    }

    private long calculateProductOfAllElements() {
        long product = 1;
        for (int i : array) {
            product *= i;
        }

        return product;
    }
}
