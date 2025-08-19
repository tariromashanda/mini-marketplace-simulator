package marketplace;

public class Seller {

    private String name;
    private String surname;
    private String email;
    private String business;


    public Seller(String name, String surname, String email, String business){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.business = business;

    }

    public void setEmail(String updateEmail){
        this.email = updateEmail;
    }

    public void setSurname(String updateSurname){
        this.email = updateSurname;
    }

}
