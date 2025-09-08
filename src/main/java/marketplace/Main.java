package marketplace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        int option;
        Dashboard currentDashboard;
        Scanner scanner = new Scanner(System.in);
        HomeDashboard homeDashboard = new HomeDashboard();
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
                BuyerDashboard buyerDashboard = new BuyerDashboard((Buyer) currentDashboard.getLoggedInUser());
                Dashboard.setDashboard(buyerDashboard);
                dashboardOrder.add(buyerDashboard);
            }

            System.out.println("Hello! "+ currentDashboard.getLoggedInUser().getUsername());

            if(option == 5){
                System.exit(0);
            }
        }

        }
    }
