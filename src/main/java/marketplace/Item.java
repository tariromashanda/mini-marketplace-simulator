package marketplace;

public class Item {
    private String name;
    private String price;
    private String category;
    private String description;


    public Item(String name, String price, String category, String description){
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    public void  editName(String new_name){
        this.name = new_name;
    }

    public void  editPrice(String new_price){
        this.name = new_price;
    }

    public void  editCategory(String new_category){
        this.name = new_category;
    }

    public void  editDescription(String new_description){
        this.name = new_description;
    }

}
