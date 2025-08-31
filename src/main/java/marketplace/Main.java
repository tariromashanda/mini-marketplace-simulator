package marketplace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int option;
        User loggedIn = null;
        Dashboard currentDashboard;

        Scanner scanner = new Scanner(System.in);
        HomeDashboard homeDashboard = new HomeDashboard();
        SellerDashboard sellerDashboard = new SellerDashboard();

        List<Dashboard> dashboardOrder = new ArrayList<>();

        dashboardOrder.add(homeDashboard);

        homeDashboard.dashboard();

        while(true){

            option = Integer.parseInt(scanner.nextLine());

            if(dashboardOrder.getLast() == homeDashboard){

               currentDashboard = dashboardOrder.getLast();

               //loggedIn = currentDashboard.ge
               dashboardOrder.add(currentDashboard);

                }

            option = Integer.parseInt(scanner.nextLine());

            if(dashboardOrder.getFirst() == sellerDashboard){
                sellerDashboard.dashboard();

                currentDashboard = sellerDashboard.handleOption((Seller) loggedIn,option);
                dashboardOrder.add(currentDashboard);
                loggedIn = homeDashboard.loggedInUser();
            }

            if(option == 5) {
                sellerDashboard.addToFile();
                break;
            }


            }





        }

    }
