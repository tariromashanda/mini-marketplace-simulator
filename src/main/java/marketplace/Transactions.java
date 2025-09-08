package marketplace;

import java.util.ArrayList;
import java.util.List;

public class Transactions {
    List<Purchase> transactions = new ArrayList<>();

    public void add(Purchase purchase){
        transactions.add(purchase);
    }

    public List<Purchase> getTransactions() {
        return transactions;
    }

    public void view(){
        for (Purchase purchase : transactions) {
            System.out.println(purchase.getBuyer());
            System.out.println(purchase.getSeller());
            System.out.println(purchase.getItem());
            System.out.println();
        }
    }

    @Override
    public String toString(){
        for(Purchase purchase: transactions){
            return "buyer: " + purchase.getBuyer() + " seller: " + purchase.getSeller() + " item: "+ purchase.getItem();
        }
        return "Inventory returned";
    }


}
