package marketplace;

public class Transaction {
    private String buyer;
    private String seller;
    private Item item;

    public Transaction(String buyer, String seller, Item item){
        this.buyer = buyer;
        this.seller = seller;
        this.item = item;

    }
}
