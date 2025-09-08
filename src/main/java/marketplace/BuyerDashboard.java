package marketplace;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BuyerDashboard extends Dashboard {
    Buyer loggedIn;
    String sellerInventory = "sellerInventory.txt";
    Map<String, Inventory> marketplace = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    public BuyerDashboard(Buyer buyer) {
        this.loggedIn = buyer;
        setLoggedInUser(buyer);
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

    public void handleOption(int option) throws FileNotFoundException {
        setMarketplace();

        switch(option){
            case 1:
                viewItems(marketplace);
                break;
            case 2:
                System.out.println("what item are you looking for?");
                String name = scanner.nextLine();
                searchItems(marketplace, name);
                break;
            case 3:
                purchaseItems();
                break;
            case 4:
                viewTransactions();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("please select an option from 1 to 5");
        }
    }


    private void viewTransactions() {
    }

    private void purchaseItems() {
    }

    private void searchItems(Map<String, Inventory> marketplace, String name) {

        boolean found = false;

        for (Map.Entry<String, Inventory> entry : marketplace.entrySet()) {
            Inventory inv = entry.getValue();
            for(int i = 0; i < inv.getInventory().size(); i++){
                if(equalsIgnoreFormatting(inv.getInventory().get(i).getName(), name)){
                    System.out.println("Found " + inv.getInventory().get(i).getName());
                    found = true;
                    break;
                }
            }

        }


        if (!found){
            System.out.println("Item not found");
        }

    }

    private boolean equalsIgnoreFormatting(String a, String b) {
        if (a == null || b == null) return false;

        String cleanA = a.trim().replaceAll("\\s+", " ").toLowerCase();
        String cleanB = b.trim().replaceAll("\\s+", " ").toLowerCase();

        return cleanA.equals(cleanB);
    }



    public void viewItems(Map<String, Inventory> marketplace) {
        marketplace.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

    }


}
