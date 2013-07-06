package tw.ymeng.algorithm.interview.product_of_elements;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProductOfElementsTest {

    @Test
    public void should_calculate_product_of_elements() {
        ProductOfElements productOfElements = new ProductOfElements(new int[]{1, 2, 3});

        List<ElementArray> result = productOfElements.calculate();

        assertProductEquals(result.get(0), 1, 6L);
    }

    private void assertProductEquals(ElementArray elementArray, int except, long productOfOthers) {
        assertThat(elementArray.except(), is(except));
        assertThat(elementArray.productOfOthers(), is(productOfOthers));
    }
}
