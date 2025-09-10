package marketplace;

import java.io.FileNotFoundException;
import java.util.*;

public class HomeDashboard extends Dashboard {

    Seller sellerLogged;
    Buyer buyerLogged;
    Inventory inventory;
    String sellerData = "sellerData.txt";
    String buyerData = "buyerData.txt";
    String sellerInventory = "sellerInventory.txt";

    Map<String, Seller> sellerDataLogin = new HashMap<>();
    Map<String, Buyer> buyerDataLogin = new HashMap<>();
    Map<String, Inventory> sellerInventoryLogin = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void handleOption(int option) throws FileNotFoundException {
        switch(option){
            case 1:
                sellerLogin();
                break;
            case 2:
                buyerLogin();
                break;
            case 3:
                signup();
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("please select an option from 1 to 3");
        }

    }

    public void dashboard(){
        System.out.println("1. seller login");
        System.out.println("2. buyer login");
        System.out.println("3. signup");
        System.out.println("4. exit");
    }

    public void signup(){

            System.out.println("enter name");
            String name = scanner.nextLine();

            System.out.println("enter surname");
            String surname = scanner.nextLine();

            System.out.println("enter username");
            String username = scanner.nextLine();

            System.out.println("enter email");
            String email = scanner.nextLine();

            System.out.println("enter password");
            String password = scanner.nextLine();

            System.out.println("select role 1. buyer 2. seller");
            String role = scanner.nextLine();

            if (Integer.parseInt(role) == 1){
                Buyer newBuyer = new Buyer(name, surname, username, email,password);
                setLoggedInUser(newBuyer);

                BuyerDashboard buyerDashboard = new BuyerDashboard(newBuyer);
                buyerDashboard.dashboard();

                String message = String.format("you have successfully registered %s", username);
                System.out.println(message);

                List<String> buyerAttributes = new ArrayList<>();
                buyerAttributes.add(newBuyer.getName());
                buyerAttributes.add(newBuyer.getSurname());
                buyerAttributes.add(newBuyer.getEmail());
                buyerAttributes.add(newBuyer.getPassword());

                myFile.createFile(buyerData);

                myFile.writeToFile(newBuyer.getUsername(), buyerAttributes, buyerData);

                buyerDashboard.setLoggedInUser(newBuyer);


            }else if (Integer.parseInt(role) == 2){
                Seller newSeller = new Seller(name, surname, username, email, password);
                setLoggedInUser(newSeller);

                SellerDashboard sellerDashboard = new SellerDashboard(newSeller);
                sellerDashboard.dashboard();

                String message = String.format("you have successfully registered %s", username);
                System.out.println(message);

                List<String> sellerAttributes = new ArrayList<>();
                sellerAttributes.add(newSeller.getName());
                sellerAttributes.add(newSeller.getSurname());
                sellerAttributes.add(newSeller.getEmail());
                sellerAttributes.add(newSeller.getPassword());

                myFile.createFile(sellerData);

                myFile.writeToFile(newSeller.getUsername(), sellerAttributes, sellerData);

                myFile.createFile(sellerInventory);

                sellerDashboard.setLoggedInUser(newSeller);

            }
    }


    public void sellerLogin() throws FileNotFoundException {

        sellerDataLogin  = myFile.readInSeller(sellerData);
        sellerInventoryLogin = myFile.readInInventory(sellerInventory);
        System.out.println(sellerInventoryLogin);

        System.out.println("enter username");
        String sellerUsername = scanner.nextLine();
        System.out.println("enter password");
        String sellerPassword = scanner.nextLine();

        if(sellerDataLogin.containsKey(sellerUsername) && (sellerDataLogin.get(sellerUsername).getPassword().equals(sellerPassword))){

            sellerLogged = sellerDataLogin.get(sellerUsername);
            inventory = sellerInventoryLogin.get(sellerUsername);

            sellerLogged.setInventory(inventory);
            setLoggedInUser(sellerLogged);
            System.out.println("you have successfully logged in " + getLoggedInUser().getUsername());
        }


    }

    public void buyerLogin() throws FileNotFoundException {
        buyerDataLogin  = myFile.readInBuyer(buyerData);
        sellerInventoryLogin = myFile.readInInventory(sellerInventory);

        System.out.println("enter username");
        String buyerUsername = scanner.nextLine();
        System.out.println("enter password");
        String buyerPassword = scanner.nextLine();

        if(buyerDataLogin.containsKey(buyerUsername) && (buyerDataLogin.get(buyerUsername).getPassword().equals(buyerPassword))){

            buyerLogged = buyerDataLogin.get(buyerUsername);

            setLoggedInUser(buyerLogged);
            System.out.println("you have successfully logged in " + getLoggedInUser().getUsername());
        }

    }

    @Override
    public String toString(){
        return "Home Dashboard";
    }

    public void exit(){
    System.exit(0);
}

}
