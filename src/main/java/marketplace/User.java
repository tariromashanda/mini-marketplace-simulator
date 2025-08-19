package marketplace;

public class User {

    private String name;
    private String surname;
    private String email;
    private String username;


    public User(String name, String surname, String email, String business){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = business;

    }

    public void setName(String updateName){
        this.name = updateName;
    }

    public void setSurname(String updateSurname){
        this.surname = updateSurname;
    }

    public void setEmail(String updateEmail){
        this.email = updateEmail;
    }

    public void setBusiness(String updateBusiness){
        this.username = updateBusiness;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getEmail(){
        return this.email;
    }

    public String getBusiness(){
        return this.username;
    }




}
