import java.util.ArrayList;

public class AdminData {
    private static ArrayList<Admin> admins = new ArrayList<>();

    AdminData() {
        Admin admin = new Admin("harsh", "harsh");
        admins.add(admin);
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }
    
    
}
