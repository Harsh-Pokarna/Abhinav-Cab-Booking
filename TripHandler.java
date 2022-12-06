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
        System.out.println("F -> View finalised trips");
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
            case "F":
                viewFinalTrips(user);
                break;
            default:
                System.out.println("Please enter a valid input");
                showMenu(user);
                break;
        }
    }

    public void viewFinalTrips(User user) {
        ArrayList<Trip> finalTrips = tripsData.getFinalTrips();

        for(Trip trip: finalTrips) {
            if(trip.getUsers().contains(user)) {
                trip.printDetails();
            }
        }

        showMenu(user);
    }

    public void viewProposedTrips(User user) {
        ArrayList<Trip> proposedTrips = tripsData.getProposedTrips();

        for(int i = 0; i<proposedTrips.size(); i++) {
            Trip trip = proposedTrips.get(i);
            if(trip.getUsers().contains(user)) {
                trip.printDetails();
                System.out.println("Enter A to accept and R to reject the trips");

                handleTripResponse(sc.nextLine(), trip, user);
            }
        }
        
        showMenu(user);
    }

    public void handleTripResponse(String input, Trip trip, User user) {
        switch(input) {
            case "A":
                acceptTrip(user, trip);
                break;
            case "R":
                tripsData.cancelTrip(trip);
                break;
            default:
                System.out.println("Please enter valid input");
                break;
        }
    }

    public void acceptTrip(User user, Trip trip) {
        if(trip.getAcceptedUsers().contains(user)) {
            System.out.println("Already accepted");
        } else {
            trip.addAcceptedUser(user);
        }
        
        if(trip.getUsers().size() == trip.getAcceptedUsers().size()) {
            tripsData.removeFromProposed(trip);
            tripsData.addToFinal(trip);
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
