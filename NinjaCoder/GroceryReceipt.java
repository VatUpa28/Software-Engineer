import java.util.ArrayList; // why am I using this, there was sooooo many other things I coudlve done
import java.util.Scanner; // well kinda have to use this cuz its important

public class GroceryReceipt { // uhhhhhhhhh, I dont like shopping

    public static void main(String[] args) { // this better end well

        ArrayList<ArrayList<String>> is = new ArrayList<>(); // the grand collection
        Scanner s = new Scanner(System.in); // something for input

        System.out.println("How many unique items?");
        int n = s.nextInt(); // store the answer
        s.nextLine(); // important for some reason

        for (int x = 0; x < n; x++) {

            ArrayList<String> i = new ArrayList<>(); // temporary arrangement while I try to find a better way

            System.out.println("Item " + (x + 1) + " name:");
            i.add(s.nextLine()); // first piece

            System.out.println("Price:");
            i.add(s.nextLine()); // money money money

            System.out.println("Quantity:");
            i.add(s.nextLine()); // more information that is important for some reason

            is.add(i); // put it with the other clowns
        }

        double st = 0; // starting point
        double it = 0; // changes as needed

        for (int x = 0; x < is.size(); x++) {

            double p = Double.parseDouble(is.get(x).get(1)); // golden retriever a value from item
            int q = Integer.parseInt(is.get(x).get(2)); // labrador retriever another value from item

            it = p * q; // such a complex operation
            st += it; // another complex operation, im gonna cry
        }

        double d = 0; // default value

        d = st >= 50 ? st * .10 : st >= 25 ? st * .05 : 0; // ooooo fun stuff, better have a good one cuz I dont want to go broke

        double tx = (st - d) * .06625; // why is the tax so high
        double t = st - d + tx; // I'm gonna broke and mentally insane by the total I get and by just looking at this calculation

        System.out.println();
        System.out.println("========== RECEIPT =========="); // here we go, im gonna get a heart attack soon

        for (int x = 0; x < is.size(); x++) {

            String nm = is.get(x).get(0); // first
            double p = Double.parseDouble(is.get(x).get(1)); // second
            int q = Integer.parseInt(is.get(x).get(2)); // third

            System.out.printf(
                "%-12s %d x $%.2f   $%.2f%n",
                nm, q, p, p * q
            ); // format accordingly
        }

        System.out.println("-----------------------------");
        System.out.printf("Subtotal:             $%.2f%n", st); // boring result 1
        System.out.printf("Discount:             $%.2f%n", d); // best part of this receipt result 2
        System.out.printf("Tax:                  $%.2f%n", tx); // im getting robbed result 3
        System.out.printf("TOTAL:                $%.2f%n", t); // heart attack result 4
        System.out.println("============================="); // finish, phew that wasnt too bad, no heart attack this time but my bank account went further in the negatives
    }
}