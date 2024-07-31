package Week1DSA.E_Commerce;

import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int numProducts = scanner.nextInt();

        Product[] products = new Product[numProducts];

        for (int i = 0; i < numProducts; i++) {
            System.out.print("Enter product ID: ");
            int productId = scanner.nextInt();
            System.out.print("Enter product name: ");
            String productName = scanner.next();
            System.out.print("Enter product category: ");
            String category = scanner.next();

            products[i] = new Product(productId, productName, category);
        }

        Arrays.sort(products, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));

        System.out.print("Enter the product ID to search: ");
        int targetProductId = scanner.nextInt();

        Product resultLinear = LinearSearch.search(products, targetProductId);
        Product resultBinary = BinarySearch.search(products, targetProductId);

        System.out.println("Linear Search Result: " + resultLinear);
        System.out.println("Binary Search Result: " + resultBinary);
    }
}
