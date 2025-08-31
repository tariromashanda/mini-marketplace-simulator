package marketplace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SellerDashboard extends Menu {
    Menu dashboard;
    User loggedIn;
    String sellerInventory = "sellerInventory.txt";

    Inventory inventory = new Inventory();
    Scanner scanner = new Scanner(System.in);

    public void dashboard(){
        System.out.println("1. Add Item");
        System.out.println("2. Edit Item");
        System.out.println("3. Delete Item");
        System.out.println("4. View My Listings");
        System.out.println("5. Logout");
    }

    public Menu handleOption(Seller seller, int option){
        switch(option){
            case 1:
                addItems(seller);
            case 2:
                inventory.dashboard();
                System.out.println("select an option");
                String editOption = scanner.nextLine();
                System.out.println("what item do you want to change?");
                String editItem = scanner.nextLine();
                System.out.println("what do you want to change the value to?");
                String editChange = scanner.nextLine();
                inventory.edit(editOption, editItem, editChange);
            case 3:
                System.out.println("What Item do you want to delete");
                String item = scanner.nextLine();
                inventory.delete(item);
            case 4:
                inventory.view();
            default:
                System.out.println("Please select an option from 1 to 5");
        }
        return dashboard;
    }

    private void addItems(Seller seller){

            System.out.println("enter item name");
            String itemName = scanner.nextLine();

            System.out.println("enter item price");
            String itemPrice = scanner.nextLine();

            System.out.println("enter item description");
            String itemDescription = scanner.nextLine();

            Item newItem = new Item(itemName, itemPrice, itemDescription);
            inventory.add(newItem);

}

private void addToFile(){

    List<List <String>> sellerInventoryList = new ArrayList<>();
    for(Item items: inventory.getInventory()){
        List<String> itemAttributes = new ArrayList<>();
        itemAttributes.add(items.getName());
        itemAttributes.add(items.getPrice());
        itemAttributes.add(items.getDescription());
        sellerInventoryList.add(itemAttributes);


    }


    myFile.writeToInventory(loggedIn.getUsername(), sellerInventoryList, sellerInventory);

}




}
