package marketplace;

public class Seller extends User{
    private Inventory inventory;

    public Seller(String name, String surname, String email, String username, String password){
        super(name, surname, email, username, password);
    }

}
