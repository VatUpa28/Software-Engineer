import java.util.ArrayList;
import java.util.Scanner;

public class GroceryReceipt {

    public static ArrayList<ArrayList<String>> addItems() {
        ArrayList<ArrayList<String>> items = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        System.out.println("How many unique items?");
        int amount = input.nextInt();
        input.nextLine();

        for (int i = 0; i < amount; i++) {
            ArrayList<String> item = new ArrayList<>();

            System.out.println("Item " + (i+1) + " name:");
            String name = input.nextLine();
            item.add(name);

            System.out.println("Price:");
            String price = input.nextLine();
            item.add(price);

            System.out.println("Quantity:");
            String quantity = input.nextLine();
            item.add(quantity);

            items.add(item);
        }

        return items;
    }

    public static double itemTotal(ArrayList<String> item) {
        double price = Double.parseDouble(item.get(1));
        int quantity = Integer.parseInt(item.get(2));

        return price * quantity;
    }

    public static double subtotal(ArrayList<ArrayList<String>> items) {
        double total = 0;

        for (int i = 0; i < items.size(); i++) {
            total += itemTotal(items.get(i));
        }

        return total;
    }

    public static double discount(double subtotal) {
        if (subtotal >= 50) {
            return subtotal * 0.10;
        }

        return 0;
    }

    public static double tax(double subtotal, double discount) {
        double taxRate = 0.06625;

        return (subtotal - discount) * taxRate;
    }

    public static double finalTotal(double subtotal, double discount, double tax) {
        return subtotal - discount + tax;
    }

    public static void printReceipt(ArrayList<ArrayList<String>> items) {
        double sub = subtotal(items);
        double disc = discount(sub);
        double taxAmount = tax(sub, disc);
        double total = finalTotal(sub, disc, taxAmount);

        System.out.println();
        System.out.println("========== RECEIPT ==========");

        for (int i = 0; i < items.size(); i++) {
            String name = items.get(i).get(0);
            double price = Double.parseDouble(items.get(i).get(1));
            int quantity = Integer.parseInt(items.get(i).get(2));
            double itemTotal = itemTotal(items.get(i));

            System.out.printf("%-12s %d x $%.2f   $%.2f%n",
                    name, quantity, price, itemTotal);
        }

        System.out.println("-----------------------------");
        System.out.printf("Subtotal:             $%.2f%n", sub);
        System.out.printf("Discount:             $%.2f%n", disc);
        System.out.printf("Tax:                  $%.2f%n", taxAmount);
        System.out.printf("TOTAL:                $%.2f%n", total);
        System.out.println("=============================");
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> items = addItems();

        printReceipt(items);
    }
}