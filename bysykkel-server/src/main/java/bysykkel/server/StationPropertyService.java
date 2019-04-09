package bysykkel.server;

import bysykkel.client.availability.Availability;
import bysykkel.client.availability.AvailabilityClient;
import bysykkel.client.availability.StationAvailability;
import bysykkel.client.station.Station;
import bysykkel.client.station.StationClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StationPropertyService {

    private StationClient stationClient;
    private AvailabilityClient availabilityClient;

    public StationPropertyService(String authToken) {
        if (authToken == null) {
            throw new IllegalStateException("missing CLIENT_IDENTIFIER in environment");
        }
        stationClient = new StationClient(authToken);
        availabilityClient = new AvailabilityClient(authToken);
    }

    public List<StationProperty> findStationProperties() {
        List<Station> stations = stationClient.findStations();
        List<StationAvailability> availabilities = availabilityClient.findStationsAvailability();

        Map<Integer, Availability> availabilityMap = availabilities.stream()
                .collect(Collectors.toMap(x -> x.id, x -> x.availability));

        List<StationProperty> stationProperties = new ArrayList<>();
        stations.forEach(station -> {
            Availability availability = availabilityMap.containsKey(station.id) ? availabilityMap.get(station.id) :
                    new Availability();
            stationProperties.add(getStationProperty(station.id, station.title, availability.bikes, availability.locks,
                    station.numberOfLocks));
        });

        return stationProperties;
    }

    private StationProperty getStationProperty(Integer id, String title, Integer bikes, Integer locks,
                                               Integer numLocks) {
        StationProperty property = new StationProperty();
        property.id = id;
        property.title = title;
        property.bikes = bikes;
        property.locks = locks;
        property.numLocks = numLocks;

        return property;
    }


}
