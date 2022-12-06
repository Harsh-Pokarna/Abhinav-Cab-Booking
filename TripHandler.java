import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Scanner;

public class TripHandler {
    Scanner sc = new Scanner(System.in);
    TripsData tripsData = new TripsData();

    private String source;
    private String destination;
    private String date;
    private String time;
    
    public void showMenu(User user) {
        System.out.println("Enter any one of the following options:");
        System.out.println("A -> Add a trip");
        System.out.println("V -> View proposed trips");
        System.out.println("L -> Logout");

        String input = sc.nextLine();
        handleInput(input, user);
    }

    public void handleInput(String input, User user) {
        switch(input) {
            case "A":
                addTrip(user);
                break;
            case "L":
                Main.showMenu();
                break;
            case "V":
                viewProposedTrips(user);
                break;
            default:
                System.out.println("Please enter a valid input");
                showMenu(user);
                break;
        }
    }

    public void viewProposedTrips(User user) {
        ArrayList<Trip> proposedTrips = tripsData.getProposedTrips();

        for(int i = 0; i<proposedTrips.size(); i++) {
            Trip trip = proposedTrips.get(i);
            if(trip.getUsers().contains(user)) {
                System.out.println("Source: " + trip.getOrigin());
                System.out.println("Destination: " + trip.getDestination());
                System.out.println("Date: " + trip.getDate());
                System.out.println("Time: " + trip.getTime());
                System.out.println("Members:");
                for(User u: trip.getUsers()) {
                    System.out.print(u.getName() + "(" + u.getID() + ")");
                }
                System.out.println("Enter A to accept and R to reject the trips");

                handleTripResponse(sc.nextLine());
            }
        }
        
        showMenu(user);
    }

    public void handleTripResponse(String input) {
        switch(input) {
            case "A":
                break;
            case "R":
                break;
            default:
                System.out.println("Please enter valid input");
                break;
        }
    }

    public void addTrip(User user) {
        System.out.println("Please enter the details of your trip in the following order: Source, Destination, Date(dd/mm/yyyy), Time(hh:mm)(in 24hr format)");

        source = sc.nextLine();
        destination = sc.nextLine();
        date = sc.nextLine();
        time = sc.nextLine();

        if(date.equals("") || source.equals("") || destination.equals("") || time.equals("")) {
            return;
        }

        ArrayList<User> users = new ArrayList<>();
        users.add(user);

        Trip trip = new Trip(source, destination, date, time, users);
        TripsData data = new TripsData();
        data.addTrip(trip);

        showMenu(user);
    }
}
