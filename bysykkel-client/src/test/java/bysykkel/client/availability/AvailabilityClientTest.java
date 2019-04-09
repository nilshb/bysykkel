package bysykkel.client.availability;

import bysykkel.client.BysykkelRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AvailabilityClientTest {

    private static final String PATH = "/stations/availability";
    private static final String AUTH_TOKEN = "SECRET";

    @Mock
    BysykkelRequest bysykkelRequest;

    @InjectMocks
    AvailabilityClient availabilityClient = new AvailabilityClient(AUTH_TOKEN);

    @Test
    public void shouldFindStationsAvailability() {
        when(bysykkelRequest.doRequest(PATH)).thenReturn(availabilityResponse);

        List<StationAvailability> stationAvailabilities = availabilityClient.findStationsAvailability();

        Assert.assertEquals(2, stationAvailabilities.size());

        Assert.assertEquals(210, stationAvailabilities.get(0).id.intValue());
        Assert.assertEquals(7, stationAvailabilities.get(0).availability.bikes.intValue());
        Assert.assertEquals(3, stationAvailabilities.get(0).availability.locks.intValue());

        Assert.assertEquals(191, stationAvailabilities.get(1).id.intValue());
        Assert.assertEquals(2, stationAvailabilities.get(1).availability.bikes.intValue());
        Assert.assertEquals(7, stationAvailabilities.get(1).availability.locks.intValue());
    }

    private static final String availabilityResponse = "{" +
            "  \"stations\": [" +
            "    {" +
            "      \"id\": 210," +
            "      \"availability\": {" +
            "        \"bikes\": 7," +
            "        \"locks\": 3" +
            "      }" +
            "    }," +
            "    {" +
            "      \"id\": 191," +
            "      \"availability\": {" +
            "        \"bikes\": 2," +
            "        \"locks\": 7" +
            "      }" +
            "    }" +
            "  ]," +
            "  \"updated_at\": \"2016-09-09T09:50:33+00:00\"," +
            "  \"refresh_rate\": 10.0" +
            "}";

}