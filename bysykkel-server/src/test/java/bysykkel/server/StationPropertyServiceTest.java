package bysykkel.server;

import bysykkel.client.availability.Availability;
import bysykkel.client.availability.AvailabilityClient;
import bysykkel.client.availability.StationAvailability;
import bysykkel.client.station.Station;
import bysykkel.client.station.StationClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class StationPropertyServiceTest {

    @Mock
    StationClient stationClient;

    @Mock
    AvailabilityClient availabilityClient;

    @InjectMocks
    StationPropertyService stationPropertyService = new StationPropertyService("SECRET");

    @Test
    public void shouldFindStationProperties() {
        when(stationClient.findStations()).thenReturn(getStations());
        when(availabilityClient.findStationsAvailability()).thenReturn(getAvalability());

        List<StationProperty> stationProperties = stationPropertyService.findStationProperties();

        Assert.assertEquals(2, stationProperties.size());
        Assert.assertEquals("foo", stationProperties.get(0).title);
        Assert.assertEquals("bar", stationProperties.get(1).title);
    }


    private static List<Station> getStations() {
        List<Station> stations = new ArrayList<>();

        Station station1 = new Station();
        station1.id = 1;
        station1.title = "foo";
        station1.numberOfLocks = 1;
        stations.add(station1);

        Station station2 = new Station();
        station2.id = 2;
        station2.title = "bar";
        station2.numberOfLocks = 2;
        stations.add(station2);

        return stations;
    }

    private static List<StationAvailability> getAvalability() {
        List<StationAvailability> availabilities = new ArrayList<>();

        Availability availability1 = new Availability();
        availability1.locks = 6;
        availability1.bikes = 3;
        StationAvailability stationAvailability1 = new StationAvailability();
        stationAvailability1.id = 1;
        stationAvailability1.availability = availability1;
        availabilities.add(stationAvailability1);

        Availability availability2 = new Availability();
        availability2.locks = 10;
        availability2.bikes = 5;
        StationAvailability stationAvailability2 = new StationAvailability();
        stationAvailability2.id = 2;
        stationAvailability2.availability = availability2;
        availabilities.add(stationAvailability2);

        return availabilities;
    }


}