package ShopperProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Shopper {

    public static void help() {

        System.out.println("\nCommands: add, remove, total, display, clear, catalogue, exit");
    }


    public static void main(String[] args) {
        boolean exit = false;
        Catalogue myCatalogue = new Catalogue();
        ArrayList<Item> catalogue = myCatalogue.generateCatalogue();
        System.out.println("\n///////CATALOGUE///////\n");
        System.out.println("ShopperProject.Item Name\tShopperProject.Item Price\n");
        for (Item o : catalogue) {
            System.out.println(o.name + "\t" + o.price + "\n");
        }
        Cart myCart = new Cart();
        do {
            System.out.println("\nCommands: add, remove, total, display, clear, catalogue, exit");
            Scanner keyboard = new Scanner(System.in);
            if (keyboard.nextLine().equalsIgnoreCase("add")) {
                myCart.addItem();
            } else if (keyboard.nextLine().equalsIgnoreCase("remove")) {
                myCart.removeItem();
            } else if (keyboard.nextLine().equalsIgnoreCase("total")) {
                myCart.totalPrice();
            } else if (keyboard.nextLine().equalsIgnoreCase("display")) {
                myCart.displayCart();
            } else if (keyboard.nextLine().equalsIgnoreCase("clear")) {
                myCart.clearCart();
            } else if (keyboard.nextLine().equalsIgnoreCase("help")) {
                help();
            } else if (keyboard.nextLine().equalsIgnoreCase("catalogue")) {
                System.out.println("\n///////CATALOGUE///////\n");
                System.out.println("ShopperProject.Item Name\tShopperProject.Item Price\n");
                for (Item o : catalogue) {
                    System.out.println(o.name + "\t" + o.price + "\n");
                }
            } else if (keyboard.nextLine().equalsIgnoreCase("exit")) {
                exit = true;
            } else if (!exit) {
                System.out.println("Command not recognised, type \"help\" for a list of commands");
            }
        } while(!exit);
    }
}
