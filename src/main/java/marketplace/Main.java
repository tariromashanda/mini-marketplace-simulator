package marketplace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int option;
        User loggedIn;

        Scanner scanner = new Scanner(System.in);
        HomeDashboard homeDashboardMenu = new HomeDashboard();
        SellerDashboard sellerDashboard = new SellerDashboard();
        BuyerDashboard buyerDashboard = new BuyerDashboard();
        String sellerData = "sellerData.txt";

        List<Menu> menuOrder = new ArrayList<>();
        List<Seller> sellersList = new ArrayList<>();
        List<Buyer> buyerList = new ArrayList<>();

        menuOrder.add(homeDashboardMenu);

        homeDashboardMenu.dashboard();

        while(true){

            option = Integer.parseInt(scanner.nextLine());

            if(menuOrder.getFirst() == homeDashboardMenu && option == 2){

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
                    loggedIn = newBuyer;


                }else{
                    Seller newSeller = new Seller(name, surname, username, email, password);
                    sellersList.add(newSeller);
                    String message = String.format("You have successfully registered %s", username);
                    System.out.println(message);
                    loggedIn = newSeller;
                    HashMap<String, List<String>> sellers = new HashMap<>();
                    List<String> sellerAttributes = new ArrayList<>();
                    sellerAttributes.add(newSeller.getName());
                    sellerAttributes.add(newSeller.getSurname());
                    sellerAttributes.add(newSeller.getEmail());
                    sellerAttributes.add(newSeller.getPassword());

                    myFile.createFile(sellerData);

                    myFile.writeToFile(newSeller.getUsername(), sellerAttributes, sellerData);



                }

                if(loggedIn instanceof Buyer){
                    menuOrder.add(buyerDashboard);
                    buyerDashboard.dashboard();

                    System.out.println("1. View Items");
                    System.out.println("2. Search Items");
                    System.out.println("3. Purchase Items");
                    System.out.println("4. View Transactions");
                    System.out.println("5. Logout");

                    String input = scanner.nextLine();

                }else{
                    menuOrder.add(sellerDashboard);
                    sellerDashboard.dashboard();
                }





            }





        }

    }
}