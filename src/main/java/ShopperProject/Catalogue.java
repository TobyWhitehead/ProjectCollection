package ShopperProject;

import java.util.ArrayList;

public class Catalogue {

    public ArrayList<Item> generateCatalogue(){
        ArrayList<Item> catalogue = new ArrayList<>();
        Item Banana = new Item("banana", 1, 0.99);
        Item Apple = new Item("apple", 1, 1.99);
        Item Orange = new Item("orange", 1, 2.99);
        catalogue.add(Banana);
        catalogue.add(Apple);
        catalogue.add(Orange);
        return (catalogue);

    }
}
