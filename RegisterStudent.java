import java.util.*;

public class RegisterStudent {
    Scanner sc = new Scanner(System.in);
    UserHandler userHandler = new UserHandler();

    private String BITSID;
    private String name;
    private String password;
    private long phoneNo;
    
    public void register() {
        System.out.println("Please enter your <BITS ID>, <Name>, <Password> and <Pone Number> in the same order");
        BITSID = sc.nextLine();
        name = sc.nextLine();
        password = sc.nextLine();
        phoneNo = Long.valueOf(sc.nextLine());

        if(BITSID.equals("") || name.equals("") || password.equals("") || Objects.isNull(phoneNo)) {
            System.out.println("Please enter all your details: ");
            return;
        }

        User user = new User(BITSID, name, password, phoneNo);
        UsersData data = new UsersData();
        if(data.getRegisteredUsers().contains(user)) {
            System.out.println("You are already Registered!");
            userHandler.showMenu();
        } else {
            data.getRegisteredUsers().add(user);
            System.out.println("You are Registered!!");
            userHandler.showMenu();
        }
    }

}
