package marketplace;

public class Seller extends User{
    private Inventory inventory = new Inventory();

    public Seller(String name, String surname, String email, String username, String password){
        super(name, surname, email, username, password);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
