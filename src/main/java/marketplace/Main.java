package marketplace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Welcome login = new Welcome();

        login.loginMenu();

        List<Menu> menuOrder = new ArrayList<>();

        menuOrder.add(login);


        while(true){
            Integer option = scanner.nextInt();

        }

    }
}