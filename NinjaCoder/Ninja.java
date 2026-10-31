// 1

import java.util.Scanner;

public static String getStatus(int a, boolean r, String g) {
    return a > 60
        ? r
            ? g.equals("male")
                ? "Senior Registered Male"
                : "Senior Registered Female"
            : g.equals("male")
                ? "Senior Unregistered Male"
                : "Senior Unregistered Female"
        : r
            ? g.equals("male")
                ? "Junior Registered Male"
                : "Junior Registered Female"
            : g.equals("male")
                ? "Junior Unregistered Male"
                : "Junior Unregistered Female";
}

// 2
public double calculateDiscountedPrice(double o, double d) {
    double a = o * (d / 100);
    return subtractDiscount(o, a);
}

public double subtractDiscount(double b, double v) {
    return b - v;
}

// 3
int x = 7; // This line makes int x 7.
public class UselessComments {
    public static int complexOperation(int x) { // very complex operation method
        int result = 0; // Makes int result 0
    
        // Nested loop to calculate something
        for (int i = 0; i < x; i++) { // loop starts at i = 0, and increments by 1 while i is less than x
            for (int j = x; j > i; j--) { // loop starts at j equaling the x value and decreases value of j by 1 while j is greater than i
                result += (i * j) % 7; // result gets added the value of the remainder of i times j when divided by 7
            }
        }
        if (result > 100) { // if the result is greater than 100 the result gets subtracted by 50
            result -= 50;
        }
        return result; // return the result
    }

    public static void main(String[] args) { // main method
        int x = 10; // sets the int x equal to 10
        int finalResult = complexOperation(x); // sets int finalResult to the result complexOperation returns when x is the input
        System.out.println("Final result: " + finalResult); // print the finalResult
    }
}

// 4
public class OrderProcessor {

    public void processOrder(String productName, double pricePerUnit, int quantity) {

        // Validate order
        if (quantity <= 0) {
            System.err.println("Error: Quantity must be greater than zero.");
            return;
        }

        // Calculate total price
        double totalPrice = pricePerUnit * quantity;

        // Log order
        System.out.println("Logging order: " + quantity
                + " units of " + productName);

        // Generate report
        System.out.println("Generating report for product: " + productName);
        System.out.println("Total price: $" + totalPrice);
    }

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.processOrder("Widget", 10.99, 5);
    }
}