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
        Dashboard prevDashboard;
        Dashboard nextDashboard;
        List<Dashboard> dashboardOrder = new ArrayList<>();

        dashboardOrder.add(homeDashboard);
        Dashboard currentDashboard = dashboardOrder.getLast();

        while(true){

            option = Integer.parseInt(scanner.nextLine());

            if(dashboardOrder.getLast() == homeDashboard){
                currentDashboard.dashboard();
                currentDashboard.handleOption(option);
                currentDashboard = currentDashboard.getDashboard();

                }

            option = Integer.parseInt(scanner.nextLine());

            if(dashboardOrder.getFirst() == sellerDashboard){
                sellerDashboard.dashboard();
                currentDashboard.dashboard();
                currentDashboard.handleOption(option);
                currentDashboard = currentDashboard.getDashboard();
            }

            if(option == 5) {
                sellerDashboard.addToFile();
                break;
            }


            }





        }

    }
