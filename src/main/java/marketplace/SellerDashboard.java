package marketplace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SellerDashboard extends Dashboard {
    Seller loggedIn;

    Inventory inventory = new Inventory();
    Scanner scanner = new Scanner(System.in);

    public SellerDashboard(Seller seller) {
        this.loggedIn = seller;
    }

    public void handleOption(int option){
        switch(option){
            case 1:
                addItems();
                break;
            case 2:
                inventory.dashboard();
                System.out.println("select an option");
                String editOption = scanner.nextLine();
                System.out.println("what item do you want to change?");
                String editItem = scanner.nextLine();
                System.out.println("what do you want to change the value to?");
                String editChange = scanner.nextLine();
                loggedIn.getInventory().edit(editOption, editItem, editChange);
                break;
            case 3:
                System.out.println("what item do you want to delete");
                String item = scanner.nextLine();
                loggedIn.getInventory().delete(item);
                break;
            case 4:
                loggedIn.getInventory().view();
                break;
            default:
                System.out.println("please select an option from 1 to 5");
        }
    }

    public void dashboard(){
        System.out.println("1. add item");
        System.out.println("2. edit item");
        System.out.println("3. delete item");
        System.out.println("4. view items");
    }

public void addItems(){

            System.out.println("enter item name");
            String itemName = scanner.nextLine();

            System.out.println("enter item price");
            String itemPrice = scanner.nextLine();

            System.out.println("enter item description");
            String itemDescription = scanner.nextLine();

            Item newItem = new Item(itemName, itemPrice, itemDescription);
            loggedIn.getInventory().add(newItem);

}

public User getloggedInUser(){
        return loggedIn;
    }

    @Override
    public String toString(){
        return "Seller Dashboard";
    }


}
