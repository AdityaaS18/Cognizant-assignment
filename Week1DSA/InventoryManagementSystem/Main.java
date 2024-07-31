package Week1DSA.InventoryManagementSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Define the Product class
class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

// Define the Inventory class
class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    // Method to add a product to the inventory
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    // Method to update a product in the inventory
    public void updateProduct(String productId, Product updatedProduct) {
        if (products.containsKey(productId)) {
            products.put(productId, updatedProduct);
        }
    }

    // Method to delete a product from the inventory
    public void deleteProduct(String productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
        }
    }

    // Method to get a product from the inventory
    public Product getProduct(String productId) {
        return products.get(productId);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an instance of the Inventory class
        Inventory inventory = new Inventory();

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Get Product");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    String productId = scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline left-over

                    Product product = new Product(productId, productName, quantity, price);
                    inventory.addProduct(product);
                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    System.out.print("Enter product ID: ");
                    String updateProductId = scanner.nextLine();
                    System.out.print("Enter new product name: ");
                    String updateProductName = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int updateQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    System.out.print("Enter new price: ");
                    double updatePrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline left-over

                    Product updatedProduct = new Product(updateProductId, updateProductName, updateQuantity, updatePrice);
                    inventory.updateProduct(updateProductId, updatedProduct);
                    System.out.println("Product updated successfully!");
                    break;

                case 3:
                    System.out.print("Enter product ID: ");
                    String deleteProductId = scanner.nextLine();
                    inventory.deleteProduct(deleteProductId);
                    System.out.println("Product deleted successfully!");
                    break;

                case 4:
                    System.out.print("Enter product ID: ");
                    String getProductID = scanner.nextLine();
                    Product retrievedProduct = inventory.getProduct(getProductID);
                    if (retrievedProduct != null) {
                        System.out.println("Product ID: " + retrievedProduct.getProductId());
                        System.out.println("Product Name: " + retrievedProduct.getProductName());
                        System.out.println("Quantity: " + retrievedProduct.getQuantity());
                        System.out.println("Price: " + retrievedProduct.getPrice());
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}