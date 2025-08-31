package marketplace;

public abstract class Dashboard {
    private Dashboard dashboard;
    private User loggedIn;

    public Dashboard getDashboard() {
        return this.dashboard;
    }

    public User getLoggedInUser(){
        return this.loggedIn;
    }

    public void setLoggedInUser(User user){
        this.loggedIn = user;
    }

    public void dashboard(){

    }

    public void handleOption(int option){

    }
}
