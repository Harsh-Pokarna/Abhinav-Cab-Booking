import java.util.Scanner;

public class AdminLogin implements Login {
    Scanner sc = new Scanner(System.in);
    AdminHandler adminHandler = new AdminHandler();

    private String username;
    private String password;

    AdminLogin() {
        System.out.println("Enter username and password");
        username = sc.nextLine();
        password = sc.nextLine();
    }

    @Override
    public int login() {
        AdminData data = new AdminData();
        for(int i = 0; i<data.getAdmins().size(); i++) {
            Admin admin = data.getAdmins().get(i);
            if(admin.getName().equals(username)) {
                if(admin.getPassword().equals(password)) {
                    System.out.println("Successfully logged in!");
                    adminHandler.showAdminMenu();
                    return 1;
                } else {
                    System.out.println("Invalid Password.");
                    adminHandler.showMenu();
                    return 0;
                }
            }
        }

        System.out.println("No admin found!");
        return 0;
    }
    
}
