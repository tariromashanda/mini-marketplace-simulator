package marketplace;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class HomeDashboard extends Menu {

    Menu dashboard;
    User loggedIn;
    String sellerData = "sellerData.txt";
    String buyerData = "buyerData.txt";
    String sellerInventory = "sellerInventory.txt";

    SellerDashboard sellerDashboard = new SellerDashboard();
    BuyerDashboard buyerDashboard = new BuyerDashboard();
    List<Seller> sellersList = new ArrayList<>();
    List<Buyer> buyerList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void dashboard(){
        System.out.println("1. login");
        System.out.println("2. sign up");
        System.out.println("3. exit");
    }

    public Menu handleOption(int option){
        switch(option){
            case 1:
                signup();
            case 2:
                login();
            case 3:
                exit();
            default:
                System.out.println("Please select an option from 1 to 3");
        }

        return dashboard;
    }

    public User loggedInUser(){
        return loggedIn;
    }

    public void signup(){

            System.out.println("Enter Name");
            String name = scanner.nextLine();

            System.out.println("Enter Surname");
            String surname = scanner.nextLine();

            System.out.println("Enter Username");
            String username = scanner.nextLine();

            System.out.println("Enter Email");
            String email = scanner.nextLine();

            System.out.println("Enter Password");
            String password = scanner.nextLine();

            System.out.println("Select role 1.Buyer 2.Seller");
            String role = scanner.nextLine();

            if (Integer.parseInt(role) == 1){
                Buyer newBuyer = new Buyer(name, surname, username, email,password);
                buyerList.add(newBuyer);
                String message = String.format("You have successfully registered %s", username);
                System.out.println(message);

                List<String> buyerAttributes = new ArrayList<>();
                buyerAttributes.add(newBuyer.getName());
                buyerAttributes.add(newBuyer.getSurname());
                buyerAttributes.add(newBuyer.getEmail());
                buyerAttributes.add(newBuyer.getPassword());

                myFile.createFile(buyerData);

                myFile.writeToFile(newBuyer.getUsername(), buyerAttributes, buyerData);

                loggedIn = newBuyer;

                dashboard = buyerDashboard;


            }else{
                Seller newSeller = new Seller(name, surname, username, email, password);
                sellersList.add(newSeller);
                String message = String.format("You have successfully registered %s", username);
                System.out.println(message);

                List<String> sellerAttributes = new ArrayList<>();
                List<String> sellerItems = new ArrayList<>();
                sellerAttributes.add(newSeller.getName());
                sellerAttributes.add(newSeller.getSurname());
                sellerAttributes.add(newSeller.getEmail());
                sellerAttributes.add(newSeller.getPassword());

                myFile.createFile(sellerData);

                myFile.writeToFile(newSeller.getUsername(), sellerAttributes, sellerData);

                myFile.createFile(sellerInventory);

                myFile.writeToFile(newSeller.getUsername(), sellerItems,sellerInventory);

                loggedIn = newSeller;

                dashboard = sellerDashboard;

            }
    }


    public void login(){

    }

    public void exit(){

    }



}
