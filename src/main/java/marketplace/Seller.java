package marketplace;

import java.util.List;

public class Seller extends User{
    public Seller(String name, String surname, String email, String username, String password){
        super(name, surname, email, username, password);
    }

    public String handleOption(Seller seller, int option){
        switch(option){
            case 1:
                return "1. Add Item";
            case 2:
                return "2. Edit Item";
            case 3:
                return "3. Delete Item";
            case 4:
                return "4. View My Listings";
            case 5:
                return "5. Logout";
            default:
                return "Please select an option from 1 to 5";
        }
    }





}
