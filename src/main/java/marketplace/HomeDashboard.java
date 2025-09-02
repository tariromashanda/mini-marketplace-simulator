package marketplace;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class HomeDashboard extends Dashboard {

    User loggedIn;
    String sellerData = "sellerData.txt";
    String buyerData = "buyerData.txt";
    String sellerInventory = "sellerInventory.txt";

    List<Seller> sellersList = new ArrayList<>();
    List<Buyer> buyerList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void handleOption(int option){
        switch(option){
            case 1:
                login();
                break;
            case 2:
                signup();
                break;
            case 3:
                exit();
                break;
            default:
                System.out.println("please select an option from 1 to 3");
        }

    }

    public void dashboard(){
        System.out.println("1. login");
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
                String message = String.format("you have successfully registered %s", username);
                System.out.println(message);

                List<String> buyerAttributes = new ArrayList<>();
                buyerAttributes.add(newBuyer.getName());
                buyerAttributes.add(newBuyer.getSurname());
                buyerAttributes.add(newBuyer.getEmail());
                buyerAttributes.add(newBuyer.getPassword());

                myFile.createFile(buyerData);

                myFile.writeToFile(newBuyer.getUsername(), buyerAttributes, buyerData);

                loggedIn = newBuyer;

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

            }
    }

    public User getLoggedInUser(){
        return this.loggedIn;
    }


    public void login(){

    }

    @Override
    public String toString(){
        return "Home Dashboard";
    }


public void exit(){

}

}
