package marketplace;

public class Purchase {
    private String buyer;
    private String seller;
    private Item item;

    public Purchase(String buyer, String seller, Item item){
        this.buyer = buyer;
        this.seller = seller;
        this.item = item;

    }

    public String getBuyer() {
        return this.buyer;
    }

    public String getSeller() {
        return this.seller;
    }

    public Item getItem() {
        return this.item;
    }
}
