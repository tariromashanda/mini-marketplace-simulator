package marketplace;

public abstract class Dashboard {
    private static Dashboard currentDashboard;
    private User loggedIn;

    public static void setDashboard(Dashboard dashboard){
        currentDashboard = dashboard;
    }

    public static Dashboard getDashboard() {
        return currentDashboard;
    }

    public User getLoggedInUser(){
        return this.loggedIn;
    }

    public void setLoggedInUser(User user){
        this.loggedIn = user;
    }

    public void handleOption(int option){

    }

    public void dashboard() {
    }

}
