import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        System.out.println("Enter A for admin mode and S for Student mode");

        switch(sc.nextLine()) {
            case "S":
                UserHandler userHandler = new UserHandler();
                userHandler.showMenu();
                break;
            case "A":
                AdminHandler adminHandler = new AdminHandler();
                adminHandler.showMenu();
                break;
        }
    }

    
}