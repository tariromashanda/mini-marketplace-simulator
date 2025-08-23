package marketplace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        String input;
        int option;

        Scanner scanner = new Scanner(System.in);

        Welcome welcomeMenu = new Welcome();

        List<Menu> menuOrder = new ArrayList<>();

        menuOrder.add(welcomeMenu);


        while(true){

            welcomeMenu.WelcomeMenu();
            option = Integer.parseInt(scanner.nextLine());

            if(menuOrder.getFirst() == welcomeMenu && option == 1){
                Register register = new Register();

                System.out.println("Enter Name");
                input = scanner.nextLine();
                register.enterName(input);

                System.out.println("Enter Surname");
                input = scanner.nextLine();
                register.enterSurname(input);

                System.out.println("Enter Username");
                input = scanner.nextLine();
                register.enterUsername(input);

                System.out.println("Select role 1.Buyer 2.Seller");
                input = scanner.nextLine();
                register.enterRole(Integer.valueOf(input));

            }





        }

    }
}