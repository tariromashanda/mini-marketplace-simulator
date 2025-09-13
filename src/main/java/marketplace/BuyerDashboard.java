package marketplace;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static marketplace.IgnoreFormatting.equalsIgnoreFormatting;

public class BuyerDashboard extends Dashboard {
    Buyer loggedIn;
    String sellerInventory = "sellerInventory.txt";
    Map<String, Inventory> marketplace = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    public BuyerDashboard(Buyer buyer) throws FileNotFoundException {
        this.loggedIn = buyer;
        setLoggedInUser(buyer);
        setMarketplace();
    }


    public void dashboard(){
        System.out.println("1. view items");
        System.out.println("2. search items");
        System.out.println("3. purchase items");
        System.out.println("4. view transactions");
        System.out.println("5. exit");
    }

    public void setMarketplace() throws FileNotFoundException {

        marketplace = myFile.readInInventory(sellerInventory);
    }

    public void handleOption(int option) throws IOException {

        switch(option){
            case 1:
                viewItems(marketplace);
                break;
            case 2:
                System.out.println("what item are you looking for?");
                String findItem = scanner.nextLine();
                searchItems(marketplace, findItem);
                break;
            case 3:
                System.out.println("what item are you looking for?");
                String buyItem = scanner.nextLine();
                System.out.println("who is it sold by??");
                String seller = scanner.nextLine();
                purchaseItems(marketplace, buyItem, seller);
                break;
            case 4:
                loggedIn.getTransaction().view();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("please select an option from 1 to 5");
        }
    }


    private void purchaseItems(Map<String, Inventory> marketplace, String name, String seller) {
        boolean bought = false;

        Inventory inventory = marketplace.get(seller);

        for(Item item: inventory.getInventory()){
            if(equalsIgnoreFormatting(item.getName(), name)){
                Purchase purchase = new Purchase(loggedIn, seller, item );
                loggedIn.getTransaction().add(purchase);
                inventory.delete(name);
                System.out.println(inventory);
                System.out.println("bought" + item.getName() +" sold by "+ seller);
                bought = true;

                myFile.createFile("transactions.txt");

                break;
            }

        }

        if (!bought){
            System.out.println("could not buy item");
        }
    }

    private void searchItems(Map<String, Inventory> marketplace, String name) {

        boolean found = false;

        for (Map.Entry<String, Inventory> entry : marketplace.entrySet()) {
            Inventory inv = entry.getValue();
            String seller = entry.getKey();
            for(int i = 0; i < inv.getInventory().size(); i++){
                if(equalsIgnoreFormatting(inv.getInventory().get(i).getName(), name)){
                    System.out.println("found" + inv.getInventory().get(i).getName() +" sold by "+ seller);
                    found = true;
                    break;
                }
            }

        }


        if (!found){
            System.out.println("item not found");
        }

    }




    public void viewItems(Map<String, Inventory> marketplace) {
        for (Map.Entry<String, Inventory> entry : marketplace.entrySet()) {
            System.out.println(marketplace);

        }
    }


}
