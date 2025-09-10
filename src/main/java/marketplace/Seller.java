package marketplace;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User{
    private Inventory inventory = new Inventory();

    public Seller(String name, String surname, String email, String username, String password){
        super(name, surname, email, username, password);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addToFile(){

        String sellerInventory = "sellerInventory.txt";

        List<List<String>> sellerInventoryList = new ArrayList<>();
        for(Item item: inventory.getInventory()){
            List<String> itemAttributes = new ArrayList<>();
            itemAttributes.add(item.getName());
            itemAttributes.add(item.getPrice());
            itemAttributes.add(item.getDescription());
            sellerInventoryList.add(itemAttributes);

        }

         myFile.overwriteInventory(getUsername(), sellerInventoryList, sellerInventory);

    }

    public String toString(){
         return getName()+ getSurname()+ getEmail()+ getUsername()+ getPassword();
    }
}
