import java.util.*;

public class UserHandler implements BaseHandler {
    static Scanner sc = new Scanner(System.in);

    public void showMenu() {
        System.out.println("Enter any one of the following options:");
        System.out.println("S -> register yourself");
        System.out.println("L -> Login");
        System.out.println("B -> Go to main page");
        
        handleInput(sc.nextLine());
    }

    public void handleInput(String input) {
        switch(input) {
            case "S": 
                registerUser();
                break;
            case "L":
                loginUser();
                break;
            case "B":
                Main.showMenu();
                break;
            default:
                System.out.println("Please enter a valid input");
                showMenu();
                break;
        }
    }

    public static void registerUser() {
        RegisterStudent register = new RegisterStudent();
        register.register();
    }

    private static void loginUser() {
        StudentLogin login = new StudentLogin();
        login.login();
    }
    
}
