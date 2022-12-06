import java.util.ArrayList;
import java.util.List;

public class User {
    private final String ID; 
    private String name;
    private String password;
    private List<Trip> trips;
    private long phoneNumber;
    
    public User(String iD, String name, String password, long phoneNo) {
        ID = iD;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNo;

        intialize();
    }

    private void intialize() {
        this.trips = new ArrayList<Trip>();
    }

    public String getPassword() {
        return password;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

}