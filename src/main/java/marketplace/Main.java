package marketplace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int option;
        User loggedIn = null;
        Menu currentDashboard;

        Scanner scanner = new Scanner(System.in);
        HomeDashboard homeDashboard = new HomeDashboard();
        SellerDashboard sellerDashboard = new SellerDashboard();
        Inventory inventory = new Inventory();
        String sellerInventory = "sellerInventory.txt";

        List<Menu> menuOrder = new ArrayList<>();

        menuOrder.add(homeDashboard);

        homeDashboard.dashboard();

        while(true){

            option = Integer.parseInt(scanner.nextLine());

            if(menuOrder.getFirst() == homeDashboard){

               currentDashboard = homeDashboard.handleOption(option);
               menuOrder.add(currentDashboard);
               loggedIn = homeDashboard.loggedInUser();

                }

            option = Integer.parseInt(scanner.nextLine());

            if(menuOrder.getFirst() == sellerDashboard){
                sellerDashboard.dashboard();

                currentDashboard = sellerDashboard.handleOption((Seller) loggedIn,option);
            }



            }





        }

    }
