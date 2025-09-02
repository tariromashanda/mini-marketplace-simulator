package marketplace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {

        int option;
        User logedIn = null;
        Dashboard currentDashboard;
        Scanner scanner = new Scanner(System.in);
        HomeDashboard homeDashboard = new HomeDashboard();
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
                SellerDashboard sellerDashboard = new SellerDashboard((Seller) currentDashboard.getLoggedInUser());
                Dashboard.setDashboard(sellerDashboard);
                dashboardOrder.add(sellerDashboard);

            }else if(currentDashboard.getLoggedInUser() instanceof Buyer && currentDashboard instanceof HomeDashboard){
                Dashboard.setDashboard(buyerDashboard);
                dashboardOrder.add(buyerDashboard);
            }

            if(option == 5){
                System.exit(0);
            }
        }

        }
    }
