package marketplace;

import java.util.ArrayList;
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

    public void delete(Item item){
        sellerItems.remove(item);
    }

    public void view(){
        for (Item sellerItem : sellerItems) {
            System.out.println(sellerItem.toString());
        }
    }

//    @Override
//    public boolean equals(Object o) {
//        if (o == this) {
//            return true;
//        }
//
//        if (!(o instanceof Item)) {
//            return false;
//        }
//
//       Item item = (Item) o;
//
//        boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
//                || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
//        return this.amount == other.amount && currencyCodeEquals;
//    }
}
