public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Add products
        Product product1 = new Product("1", "Laptop", 10, 999.99);
        Product product2 = new Product("2", "Smartphone", 20, 499.99);
        Product product3 = new Product("3", "Tablet", 15, 299.99);

        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        // Display products
        System.out.println("Initial inventory:");
        inventory.displayProducts();

        // Update product
        product1.setQuantity(8);
        inventory.updateProduct(product1);

        // Display products after update
        System.out.println("\nInventory after updating Laptop quantity:");
        inventory.displayProducts();

        // Delete product
        inventory.deleteProduct("2");

        // Display products after deletion
        System.out.println("\nInventory after deleting Smartphone:");
        inventory.displayProducts();

        // Get specific product
        Product retrievedProduct = inventory.getProduct("3");
        System.out.println("\nRetrieved product: " + retrievedProduct);
    }
}
