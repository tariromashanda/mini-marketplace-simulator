package marketplace;

import java.util.List;

public class Inventory {
    List<Item> sellerItems;

    public Inventory(List<Item> sellerInventory){
        this.sellerItems = sellerInventory;
    }

    public void add(Item item){
        sellerItems.add(item);
    }

    public void edit(Item item){
        sellerItems.add(item);
    }

    public void delete( Item item){
        sellerItems.add(item);
    }
}
