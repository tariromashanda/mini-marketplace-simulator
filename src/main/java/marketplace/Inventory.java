package marketplace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Item> inventory = new ArrayList<>();

    public void add(Item item){
        inventory.add(item);
    }

    public void edit(String itemName, String option, String newValue) throws IOException {
        boolean edited = false;
        String target = itemName.trim();
        String oldValue;

        for (Item sellerItem : inventory) {
            if (sellerItem.getName().trim().equalsIgnoreCase(target)) {
                switch (Integer.parseInt(option)) {
                    case 1:
                        oldValue = sellerItem.getName();
                        sellerItem.editName(newValue);
                        break;
                    case 2:
                        oldValue = sellerItem.getPrice();
                        sellerItem.editPrice(newValue);
                        break;
                    case 3:
                        oldValue = sellerItem.getDescription();
                        sellerItem.editDescription(newValue);
                        break;
                    default:
                        System.out.println("please select an option from 1 to 3");
                        return;
                }
                edited = true;
                myFile.updateFile("sellerInventory.txt", oldValue, newValue);
                break;
            }
        }
        if (!edited) {
            System.out.println("item not found: " + itemName);
        }
    }

    public void delete(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            Item current = inventory.get(i);
            if (current.getName().equals(itemName)) {
                inventory.remove(i);
                break;
            }
        }
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void view(){
        for (Item item : inventory) {
            System.out.println(item.getName());
            System.out.println(item.getPrice());
            System.out.println(item.getDescription());
            System.out.println();
        }
    }




}
