package marketplace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int option;
        User loggedIn = null;

        Scanner scanner = new Scanner(System.in);
        HomeDashboard homeDashboard = new HomeDashboard();
        SellerDashboard sellerDashboard = new SellerDashboard();
        List<Dashboard> dashboardOrder = new ArrayList<>();

        Dashboard.setDashboard(homeDashboard);

        dashboardOrder.add(homeDashboard);

        Dashboard currentDashboard = dashboardOrder.getLast();
        System.out.println(currentDashboard);

        while(true){

            currentDashboard.dashboard();
            option = Integer.parseInt(scanner.nextLine());
            Dashboard.getDashboard().handleOption(option);


            if(option == 5) {
                sellerDashboard.addToFile();
                break;
            }


            }





        }

    }
