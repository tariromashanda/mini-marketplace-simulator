package marketplace;

public class User {

    private String name;
    private String surname;
    private String email;
    private String username;
    private String password;


    public User(String name, String surname, String username, String email, String password){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;

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

    public void setUsername(String updateUsername){this.username = username;}

    public void setPassword(String updatePassword){this.username = password;}

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getEmail(){
        return this.email;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){ return this.password;}




}
