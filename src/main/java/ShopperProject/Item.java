package ShopperProject;

public class Item {
    double price;
    String name;
    int quantity;

    public Item(String vname, int vquantity, double vprice) {
        price = vprice;
        name = vname;
        quantity = vquantity;
    }
}
