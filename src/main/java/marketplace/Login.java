package marketplace;

public class Login {

    public void printLogin(){
        System.out.println("Enter login details");
    }

    public String enterName(String name){

        System.out.println("Enter Name");
        return name;
    }

    public String enterSurname(String surname){

        System.out.println("Enter Surname");
        return surname;
    }

    public String enterUsername(String userName){

        System.out.println("Enter Username");
        return userName;
    }

    public Integer enterRole(Integer role){

        System.out.println("Select role 1.Buyer 2.Seller");
        return role;
    }
}
