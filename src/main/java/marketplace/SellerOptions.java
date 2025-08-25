package marketplace;
//save and load objects using file I/O
public class SellerOptions {
    public String handleOption(Buyer buyer, int option){
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
                return null;
        }
    }
}
