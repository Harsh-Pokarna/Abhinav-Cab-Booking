import java.util.ArrayList;

public class Trip {
    private String ID;
    private String destination;
    private String origin;
    private String date;
    private String time;
    private ArrayList<User> users;
    private ArrayList<User> acceptedUsers;

    public Trip(String origin, String destination, String date, String time, ArrayList<User> users) {
        this.destination = destination;
        this.origin = origin;
        this.date = date;
        this.time = time;
        this.users = users;

        intialize();
    }

    private void intialize() {
        this.ID = Double.toString(Math.random() * 100) + date;
        acceptedUsers = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

    public String getDestination() {
        return destination;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public ArrayList<User> getAcceptedUsers() {
        return acceptedUsers;
    }

    public void addAcceptedUser(User user) {
        this.acceptedUsers.add(user);
    }

    public void addUsers(ArrayList<User> u) {
        this.getUsers().addAll(u);
    }

    public int getAbsoluteTime() {
        String[] arr = this.getTime().split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }

    public String getAllUsers() {
        StringBuilder s = new StringBuilder("");
        for(int i = 0; i<this.getUsers().size(); i++) {
            s.append(" ");
            s.append(getUsers().get(i).getID());
        }
        return s.toString();
    }

    public void printDetails() {
        System.out.println("Source: " + this.getOrigin());
        System.out.println("Destination: " + this.getDestination());
        System.out.println("Date: " + this.getDate());
        System.out.println("Time: " + this.getTime());
        System.out.println("Members:");
        for(User u: this.getUsers()) {
            System.out.println(u.getName() + "(" + u.getID() + ")");
        }
    }

}