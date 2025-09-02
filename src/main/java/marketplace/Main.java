package marketplace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int option;
        Dashboard currentDashboard;
        Scanner scanner = new Scanner(System.in);
        HomeDashboard homeDashboard = new HomeDashboard();
        SellerDashboard sellerDashboard = new SellerDashboard();
        BuyerDashboard buyerDashboard = new BuyerDashboard();
        List<Dashboard> dashboardOrder = new ArrayList<>();

        Dashboard.setDashboard(homeDashboard);

        dashboardOrder.add(homeDashboard);

        while(true){

            currentDashboard = dashboardOrder.getLast();
            currentDashboard.dashboard();
            option = Integer.parseInt(scanner.nextLine());
            Dashboard.getDashboard().handleOption(option);

            if(currentDashboard.getLoggedInUser() instanceof Seller && currentDashboard instanceof HomeDashboard){
                Dashboard.setDashboard(sellerDashboard);
                dashboardOrder.add(sellerDashboard);

            }else if(currentDashboard.getLoggedInUser() instanceof Buyer && currentDashboard instanceof HomeDashboard){
                Dashboard.setDashboard(buyerDashboard);
                dashboardOrder.add(buyerDashboard);
            }


            if(option == 5) {
                sellerDashboard.addToFile();
                break;
            }


            }





        }

    }
