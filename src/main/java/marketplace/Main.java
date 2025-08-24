package marketplace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int option;

        Scanner scanner = new Scanner(System.in);

        Welcome welcomeMenu = new Welcome();

        List<Menu> menuOrder = new ArrayList<>();
        List<Seller> sellersList = new ArrayList<>();
        List<Buyer> buyerList = new ArrayList<>();

        menuOrder.add(welcomeMenu);

        welcomeMenu.WelcomeMenu();

        while(true){

            option = Integer.parseInt(scanner.nextLine());

            if(menuOrder.getFirst() == welcomeMenu && option == 2){

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

                }else{
                    Seller newSeller = new Seller(name, surname, username, email, password);
                    sellersList.add(newSeller);
                    String message = String.format("You have successfully registered %s", username);
                    System.out.println(message);
                    System.out.println(newSeller);

                }

            }





        }

    }
}