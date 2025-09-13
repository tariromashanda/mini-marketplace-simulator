package marketplace;

public class Buyer extends User{
    private Transactions transactions = new Transactions();

    public Buyer(String name, String surname, String email, String username, String password){
        super(name, surname, email, username, password);
    }


    public Transactions getTransaction(){
        return this.transactions;
    }


}
