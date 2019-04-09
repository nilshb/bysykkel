package bysykkel.client;

import bysykkel.client.availability.Availability;
import bysykkel.client.availability.AvailabilityClient;
import bysykkel.client.availability.StationAvailability;
import bysykkel.client.station.Station;
import bysykkel.client.station.StationClient;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Console {

    private void fetchAndDisplay() {

        try {
            String authToken = System.getenv("CLIENT_IDENTIFIER");
            if (authToken == null) {
                throw new BysykkelClientException("missing CLIENT_IDENTIFIER in environment");
            }

            List<Station> stations = new StationClient(authToken).findStations();
            List<StationAvailability> stationsAvailability = new AvailabilityClient(authToken).findStationsAvailability();

            Map<Integer, Availability> availabilityMap = stationsAvailability.stream()
                    .collect(Collectors.toMap(x -> x.id, x -> x.availability));

            System.out.println("-----------------------------------------------------------------------");
            System.out.printf("%5s %30s %10s %10s %10s", "ID", "NAME", "BIKES", "LOCKS", "NUM LOCKS");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------");
            stations.forEach(x -> {
                Availability availability = availabilityMap.containsKey(x.id) ? availabilityMap.get(x.id) :
                        new Availability();
                System.out.format("%5s %30s %10s %10s %10s", x.id, x.title, availability.bikes, availability.locks,
                        x.numberOfLocks);
                System.out.println();
            });
            System.out.println("-----------------------------------------------------------------------");
        } catch (BysykkelClientException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Console console = new Console();
        console.fetchAndDisplay();
    }
}
