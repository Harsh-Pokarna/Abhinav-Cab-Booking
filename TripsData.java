import java.util.ArrayList;

public class TripsData {
    private static ArrayList<Trip> requestedTrips = new ArrayList<>();
    private static ArrayList<Trip> proposedTrips = new ArrayList<>();
    private static ArrayList<Trip> finalTrips = new ArrayList<>();

    public ArrayList<Trip> getRequestedTrips() {
        return requestedTrips;
    }

    public ArrayList<Trip> getProposedTrips() {
        return proposedTrips;
    }

    public ArrayList<Trip> getFinalTrips() {
        return finalTrips;
    }

    public void setProposedTrips(ArrayList<Trip> trips) {
        proposedTrips = trips;
    }

    public void addTrip(Trip trip) {
        requestedTrips.add(trip);
    }

    public void removeFromProposed(Trip trip) {
        proposedTrips.remove(trip);
    }

    public void addToFinal(Trip trip) {
        finalTrips.add(trip);
    }

    public void cancelTrip(Trip trip) {
        proposedTrips.remove(trip);
    }

}