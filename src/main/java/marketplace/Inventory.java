package marketplace;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Item> sellerItems = new ArrayList<>();

    public void add(Item item){
        sellerItems.add(item);
    }

    public void dashboard(){
        System.out.println("1. change name");
        System.out.println("2. change price");
        System.out.println("3. change description");

    }

    public void edit(String item, String option, String edit){
        for(Item sellerItem: sellerItems){
            if (sellerItem.equals(item)){
                switch(Integer.valueOf(option)){
                    case 1:
                        sellerItem.editName(edit);
                    case 2:
                        sellerItem.editPrice(edit);
                    case 3:
                        sellerItem.editDescription(edit);
                    default:
                        System.out.println("please select an option from 1 to 3");
                }

            }
        }
    }

    public void delete(String item){

        for(Item findItem: sellerItems ){
            if(findItem.getName().toString().equals(item)){
                sellerItems.remove(findItem);
            }
        }
    }

    public void view(){
        for (Item item : sellerItems) {
            System.out.println(item.getName());
            System.out.println(item.getPrice());
            System.out.println(item.getDescription());
            System.out.println();
        }
    }

    public List<Item> getInventory(){
        return sellerItems;
    }

}
