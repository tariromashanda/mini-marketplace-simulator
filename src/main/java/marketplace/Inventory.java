package marketplace;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Item> inventory = new ArrayList<>();

    public void add(Item item){
        inventory.add(item);
    }

    public void dashboard(){
        System.out.println("1. change name");
        System.out.println("2. change price");
        System.out.println("3. change description");

    }

    public void edit(String item, String option, String edit){
        for(Item sellerItem: inventory){
            if (sellerItem.getName().equals(item)){
                switch(Integer.parseInt(option)){
                    case 1:
                        sellerItem.editName(edit);
                        break;
                    case 2:
                        sellerItem.editPrice(edit);
                        break;
                    case 3:
                        sellerItem.editDescription(edit);
                        break;
                    default:
                        System.out.println("please select an option from 1 to 3");
                }

            }
        }
    }

    public void delete(String item){
        inventory.remove(item);

    }

    public void view(){
        for (Item item : inventory) {
            System.out.println(item.getName());
            System.out.println(item.getPrice());
            System.out.println(item.getDescription());
            System.out.println();
        }
    }

    public List<Item> getInventory(){
        return inventory;
    }

}
