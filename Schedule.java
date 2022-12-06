import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Schedule {
    TripsData tripsData = new TripsData();
    ArrayList<Trip> allTrips = tripsData.getRequestedTrips();
    HashMap<String, ArrayList<Trip>> similarTrips = new HashMap<>();
    ArrayList<Trip> finalTrips = new ArrayList<>();

    public void scheduleTrips() {

        // Entering data into hashmap for similar trips
        for(int i = 0; i<allTrips.size(); i++) {
            Trip trip = allTrips.get(i);
            String id = trip.getOrigin() + ";" + trip.getDestination() + ";" + trip.getDate();

            if(similarTrips.containsKey(id)) {
                ArrayList<Trip> trips = similarTrips.get(id);
                trips.add(trip);
                similarTrips.put(id, trips);
            } else {
                ArrayList<Trip> trips = new ArrayList<>();
                trips.add(trip);
                similarTrips.put(id, trips);
            }
        }

        //Grouping similar trips and adding them to finalTrips
        for(Map.Entry<String, ArrayList<Trip>> tripEntry: similarTrips.entrySet()) {
            ArrayList<Trip> trips = tripEntry.getValue();
            Comparator<Trip> cmp = new Comparator<Trip>() {
                @Override
                public int compare(Trip o1, Trip o2) {
                    return o1.getTime().compareTo(o2.getTime());
                }
            };

            trips.sort(cmp);
            
            for(int i = 0; i<trips.size(); i++) {
                int j = i + 1;
                Trip startTrip = trips.get(i);
                int time = startTrip.getAbsoluteTime();
                while(j<trips.size() && (trips.get(j).getAbsoluteTime() - time <= 30)) {
                    startTrip.addUsers(trips.get(j).getUsers());
                    j++;
                }
                finalTrips.add(startTrip);
                i = j-1;
            }
        }

        for(Trip t: finalTrips) {
            t.printDetails();
        }

        //setting proposed trips data
        tripsData.setProposedTrips(finalTrips);
    }
    
}
