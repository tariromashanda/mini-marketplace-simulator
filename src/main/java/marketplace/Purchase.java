package marketplace;

public class Purchase {
    private Buyer buyer;
    private String seller;
    private Item item;

    public Purchase(Buyer buyer, String seller, Item item){
        this.buyer = buyer;
        this.seller = seller;
        this.item = item;

    }


    public Buyer getBuyer() {
        return this.buyer;
    }

    public String getSeller() {
        return this.seller;
    }

    public Item getItem() {
        return this.item;
    }
}
