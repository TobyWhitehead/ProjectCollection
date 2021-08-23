package shopperProject;

import java.util.ArrayList;

public class Catalogue {

    public ArrayList<Item> generateCatalogue(){
        ArrayList<Item> catalogue = new ArrayList<>();
        Item banana = new Item("banana", 1, 0.99);
        Item apple = new Item("apple", 1, 1.99);
        Item orange = new Item("orange", 1, 2.99);
        catalogue.add(banana);
        catalogue.add(apple);
        catalogue.add(orange);
        return (catalogue);

    }
}
