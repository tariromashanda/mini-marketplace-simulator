package marketplace;

public class Item {
    private String name;
    private String price;
    private String description;

    public Item(String name, String price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void editName(String new_name){
        this.name = new_name;
    }

    public void editPrice(String new_price){
        this.price = new_price;
    }

    public void editDescription(String new_description){
        this.description = new_description;
    }

    public String getName(){
        return this.name;
    }

    public String getPrice(){
        return this.price;
    }


    public String getDescription(){
        return this.description;
    }

    @Override
    public String toString(){
        return "name: " + this.name + "price: " + this.price + "description: "+ this.description;
    }

}
