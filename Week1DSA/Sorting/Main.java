package Week1DSA.Sorting;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of orders: ");
        int numOrders = scanner.nextInt();

        Order[] orders = new Order[numOrders];

        for (int i = 0; i < numOrders; i++) {
            System.out.print("Enter order ID " + (i + 1) + ": ");
            int orderId = scanner.nextInt();

            System.out.print("Enter customer name " + (i + 1) + ": ");
            String customerName = scanner.next();

            System.out.print("Enter total price " + (i + 1) + ": ");
            double totalPrice = scanner.nextDouble();

            orders[i] = new Order(orderId, customerName, totalPrice);
        }

        System.out.println("Unsorted Orders:");
        printOrders(orders);

        System.out.println("Choose a sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        int choice = scanner.nextInt();

        if (choice == 1) {
            BubbleSort.sortOrders(orders);
            System.out.println("Sorted Orders using Bubble Sort:");
        } else if (choice == 2) {
            QuickSort.sortOrders(orders);
            System.out.println("Sorted Orders using Quick Sort:");
        }

        printOrders(orders);
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer Name: " + order.getCustomerName() + ", Total Price: " + order.getTotalPrice());
        }
    }
}