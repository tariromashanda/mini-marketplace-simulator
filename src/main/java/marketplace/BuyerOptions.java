package marketplace;
//save and load objects using file I/O
public class BuyerOptions {
    public String handleOption(Buyer buyer, int option){
        switch(option){
            case 1:
                return "1. View Items";
            case 2:
                return "2. Search Items";
            case 3:
                return "3. Purchase Items";
            case 4:
                return "4. View Transactions";
            case 5:
                return "5. Logout";
            default:
                return null;
        }
    }


}
