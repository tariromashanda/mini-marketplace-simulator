package marketplace;

import java.util.*;

public class HomeDashboard extends Dashboard {

    User loggedIn;
    String sellerData = "sellerData.txt";
    String buyerData = "buyerData.txt";
    String sellerInventory = "sellerInventory.txt";

    Map<String, Seller> sellerList = new HashMap<>();
    List<Buyer> buyerList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void handleOption(int option){
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
        System.out.println("1. buyer login");
        System.out.println("2. signup");
        System.out.println("3. exit");
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
                buyerList.add(newBuyer);
                loggedIn = newBuyer;

                String message = String.format("you have successfully registered %s", username);
                System.out.println(message);

                List<String> buyerAttributes = new ArrayList<>();
                buyerAttributes.add(newBuyer.getName());
                buyerAttributes.add(newBuyer.getSurname());
                buyerAttributes.add(newBuyer.getEmail());
                buyerAttributes.add(newBuyer.getPassword());

                myFile.createFile(buyerData);

                myFile.writeToFile(newBuyer.getUsername(), buyerAttributes, buyerData);


            }else{
                Seller newSeller = new Seller(name, surname, username, email, password);
                loggedIn = newSeller;

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

            }
    }

    public User getLoggedInUser(){
        return this.loggedIn;
    }

    public void sellerLogin(){

        sellerList = myFile.readInSeller(sellerData);

        System.out.println("enter username");
        String sellerUsername = scanner.nextLine();
        System.out.println("enter password");
        String sellerPassword = scanner.nextLine();

        if(sellerList.containsKey(sellerUsername) && (sellerList.get(sellerUsername).getPassword().equals(sellerPassword))){
            loggedIn = (sellerList.get(sellerUsername));
            System.out.println("you have succesfully logged in " + loggedIn.getUsername());
        }

    }

    public void buyerLogin(){

    }

    @Override
    public String toString(){
        return "Home Dashboard";
    }

    public void exit(){
    System.exit(0);
}

}
