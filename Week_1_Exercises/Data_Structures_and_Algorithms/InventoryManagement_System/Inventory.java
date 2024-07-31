import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    // Add product
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    // Update product
    public void updateProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    // Delete product
    public void deleteProduct(String productId) {
        products.remove(productId);
    }

    // Get product
    public Product getProduct(String productId) {
        return products.get(productId);
    }

    // Display products
    public void displayProducts() {
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }
}
