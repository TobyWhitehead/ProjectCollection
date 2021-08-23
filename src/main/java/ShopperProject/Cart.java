package ShopperProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    ArrayList<Item> cartlist = new ArrayList<>();

    void displayCart() {
        for (Item temp1 : cartlist) {
            System.out.println("\n" + temp1.quantity + " " + temp1.name + " " + temp1.price);
        }
    }

    void clearCart() {
        cartlist.clear();
        System.out.println("\nShopperProject.Cart cleared");
    }

    void addItem() {
        Catalogue myCatalogue = new Catalogue();
        ArrayList<Item> catalogue = myCatalogue.generateCatalogue();
        System.out.println("Enter item name: ");
        Scanner keyboard = new Scanner(System.in);
        String input_name = keyboard.nextLine();
        System.out.println("Enter purchase quantity: ");
        Scanner keyboard2 = new Scanner(System.in);
        String input_quantity = keyboard2.nextLine();
        boolean in_catalogue = false;
        for (Item temp2 : catalogue) {
            if(input_name.equalsIgnoreCase(temp2.name)) {
                in_catalogue = true;
                boolean in_cartlist = false;
                for (Item temp3 : cartlist) {
                    if (temp3.name.equals(temp2.name)) {
                        temp3.quantity += Integer.parseInt(input_quantity);
                        in_cartlist = true;
                    }
                }
                if (!in_cartlist) {
                    temp2.quantity = Integer.parseInt(input_quantity);
                    cartlist.add(temp2);
                }
            }
        }
        if (!in_catalogue) {
            System.out.println("\nShopperProject.Item not found in catalogue");
        }
    }

    void removeItem() {
        System.out.println("Enter item name: ");
        Scanner keyboard = new Scanner(System.in);
        String input_name = keyboard.nextLine();
        System.out.println("Enter quantity to remove: ");
        Scanner keyboard2 = new Scanner(System.in);
        String input_quantity = keyboard2.nextLine();
        boolean in_list = false;
        for (Item temp3 : cartlist) {
            if (temp3.name.equals(input_name)) {
                in_list = true;
                temp3.quantity -= Integer.parseInt(input_quantity);
            }
            if (temp3.quantity <= 0) {
                cartlist.remove(temp3);
            }
        }
        if (!in_list) {
            System.out.println("\nShopperProject.Item not found in cart");
        }
    }

    void totalPrice() {
        int total_cost = 0;
        for (Item item: cartlist) {
            double temp_price1 = item.price * (double) item.quantity;
            total_cost += (int) (temp_price1 * 100);
        }
        double total_cost_out = ((double) total_cost)/100;
        System.out.println("\ntotal cost of items in cart: " + total_cost_out);
    }
}
