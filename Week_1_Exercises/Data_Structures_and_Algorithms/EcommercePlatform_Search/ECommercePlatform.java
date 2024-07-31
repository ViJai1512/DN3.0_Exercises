// Linear Search

import java.util.ArrayList;
import java.util.List;

public class ECommercePlatform {
    private List<Product> products;

    public ECommercePlatform() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product linearSearchByProductName(String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }
}
