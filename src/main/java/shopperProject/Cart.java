package shopperProject;

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
        String inputName = keyboard.nextLine();
        System.out.println("Enter purchase quantity: ");
        Scanner keyboard2 = new Scanner(System.in);
        String inputQuantity = keyboard2.nextLine();
        boolean inCatalogue = false;
        for (Item temp2 : catalogue) {
            if(inputName.equalsIgnoreCase(temp2.name)) {
                inCatalogue = true;
                boolean inCartlist = false;
                for (Item temp3 : cartlist) {
                    if (temp3.name.equals(temp2.name)) {
                        temp3.quantity += Integer.parseInt(inputQuantity);
                        inCartlist = true;
                    }
                }
                if (!inCartlist) {
                    temp2.quantity = Integer.parseInt(inputQuantity);
                    cartlist.add(temp2);
                }
            }
        }
        if (!inCatalogue) {
            System.out.println("\nShopperProject.Item not found in catalogue");
        }
    }

    void removeItem() {
        System.out.println("Enter item name: ");
        Scanner keyboard = new Scanner(System.in);
        String inputName = keyboard.nextLine();
        System.out.println("Enter quantity to remove: ");
        Scanner keyboard2 = new Scanner(System.in);
        String inputQuantity = keyboard2.nextLine();
        boolean inList = false;
        for (Item temp3 : cartlist) {
            if (temp3.name.equals(inputName)) {
                inList = true;
                temp3.quantity -= Integer.parseInt(inputQuantity);
            }
            if (temp3.quantity <= 0) {
                cartlist.remove(temp3);
            }
        }
        if (!inList) {
            System.out.println("\nShopperProject.Item not found in cart");
        }
    }

    void totalPrice() {
        int totalCost = 0;
        for (Item item: cartlist) {
            double tempPrice1 = item.price * item.quantity;
            totalCost += (int) (tempPrice1 * 100);
        }
        double totalCostOut = ((double) totalCost)/100;
        System.out.println("\ntotal cost of items in cart: " + totalCostOut);
    }
}
