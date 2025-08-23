package marketplace;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Welcome login = new Welcome();

        login.loginMenu();

        Integer option = scanner.nextInt();

        System.out.println(option);

    }
}