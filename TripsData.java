import java.util.ArrayList;

public class TripsData {
    private static ArrayList<Trip> requestedTrips = new ArrayList<>();
    private static ArrayList<Trip> proposedTrips = new ArrayList<>();

    public ArrayList<Trip> getRequestedTrips() {
        return requestedTrips;
    }

    public ArrayList<Trip> getProposedTrips() {
        return proposedTrips;
    }

    public void setProposedTrips(ArrayList<Trip> trips) {
        proposedTrips = trips;
    }

    public void addTrip(Trip trip) {
        System.out.println("Add trip is called here");
        requestedTrips.add(trip);
    }

}