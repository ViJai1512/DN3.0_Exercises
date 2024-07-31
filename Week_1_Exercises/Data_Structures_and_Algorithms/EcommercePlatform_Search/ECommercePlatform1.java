import java.util.Collections;
import java.util.Comparator;

//Binary Search

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

    public Product binarySearchByProductName(String productName) {
        // Sort the list of products by productName
        Collections.sort(products, Comparator.comparing(Product::getProductName));

        int left = 0;
        int right = products.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Product midProduct = products.get(mid);

            int comparisonResult = midProduct.getProductName().compareToIgnoreCase(productName);
            if (comparisonResult == 0) {
                return midProduct;
            } else if (comparisonResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
