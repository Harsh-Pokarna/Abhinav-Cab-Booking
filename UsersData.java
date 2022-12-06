import java.util.ArrayList;

public class UsersData {
    private static ArrayList<User> registeredUsers = new ArrayList<>();

    public ArrayList<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public boolean isRegistered(User user) {
        return UsersData.registeredUsers.contains(user);
    }

    public void addUser(User user) {
        UsersData.registeredUsers.add(user);
    }


}