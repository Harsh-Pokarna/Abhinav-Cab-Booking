import java.util.ArrayList;
import java.util.Scanner;

public class StudentLogin implements Login {
    Scanner sc = new Scanner(System.in);

    private String username;
    private String password;
    
    StudentLogin() {
        System.out.println("Please enter your BITS ID and Password");
        username = sc.nextLine();
        password = sc.nextLine();
    }

    public int login() {
        UsersData data = new UsersData();
        ArrayList<User> ar = data.getRegisteredUsers();
        System.out.println(ar);
        TripHandler handler = new TripHandler();
        UserHandler userHandler = new UserHandler();

        for(int i = 0; i<ar.size(); i++) {
            if(ar.get(i).getID().equals(username)) {
                User u = ar.get(i);
                Thread t = new Thread(u);
                t.start();
                if(u.getPassword().equals(password)) {
                    System.out.println("Login Successful!!");
                    handler.showMenu(u);

                } else {
                    System.out.println("Incorrect Password!");
                    userHandler.showMenu();
                }
            }
        }

        System.out.println("No User Found");
        userHandler.showMenu();
        return 1;
    }
}