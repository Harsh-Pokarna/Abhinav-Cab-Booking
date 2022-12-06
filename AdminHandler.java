import java.util.Scanner;

public class AdminHandler implements BaseHandler {
    Scanner sc = new Scanner(System.in);

    public void showMenu() {
        System.out.println("Enter any one of the following options:");
        System.out.println("L -> Login");
        System.out.println("B -> Go to home page");

        handleInput(sc.nextLine());
        
    }

    public void showAdminMenu() {
        System.out.println("Enter any one of the following options:");
        System.out.println("P -> Print details of all users");
        System.out.println("S -> Schedule trips");
        System.out.println("B -> View Billings");
        System.out.println("L -> Logout");

        handleAdminInput(sc.nextLine());
    }

    public void handleAdminInput(String input) {
        switch(input) {
            case "P":
                printDetails();
                break;
            case "L":
                Main.showMenu();;
                break;
            case "S":
                scheduleTrips();
                break;
        }
    }

    public void handleInput(String input) {
        switch(input) {
            case "L":
                loginAdmin();
                break;
            case "B":
                Main.showMenu();
                break;
            default:
                System.out.println("Please enter a valid string");
                showMenu();
                break;
        }
    }

    public void printDetails() {
        UsersData data = new UsersData();
        for(User user: data.getRegisteredUsers()) {
            System.out.println("Name: " + user.getName());
            System.out.println("BITSID: " + user.getID());
            System.out.println("Contact info: " + user.getPhoneNumber());
            System.out.println("");
        }

        showAdminMenu();
    }

    public void loginAdmin() {
        AdminLogin login = new AdminLogin();    
        login.login();
    }

    public void scheduleTrips() {
        Schedule schedule = new Schedule();
        schedule.scheduleTrips();
        showAdminMenu();
    }
    
}
