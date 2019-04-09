package bysykkel.client.station;

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
public class StationClientTest {

    private static final String PATH = "/stations";
    private static final String AUTH_TOKEN = "SECRET";

    @Mock
    BysykkelRequest bysykkelRequest;

    @InjectMocks
    StationClient stationClient = new StationClient(AUTH_TOKEN);

    @Test
    public void shouldFindStations() {
        when(bysykkelRequest.doRequest(PATH)).thenReturn(stationsResponse);

        List<Station> stations = stationClient.findStations();

        Assert.assertEquals(2, stations.size());

        Assert.assertEquals(210, stations.get(0).id.intValue());
        Assert.assertEquals("Birkelunden", stations.get(0).title);
        Assert.assertEquals(10, stations.get(0).numberOfLocks.intValue());

        Assert.assertEquals(191, stations.get(1).id.intValue());
        Assert.assertEquals("Jakob kirke", stations.get(1).title);
        Assert.assertEquals(9, stations.get(1).numberOfLocks.intValue());
    }


    private static final String stationsResponse = "{" +
            "  \"stations\":[" +
            "    {" +
            "      \"id\": 210," +
            "      \"title\": \"Birkelunden\"," +
            "      \"subtitle\": \"langs Seilduksgata\"," +
            "      \"number_of_locks\": 10," +
            "      \"center\": {" +
            "        \"latitude\": 59.925622," +
            "        \"longitude\": 10.760822" +
            "      }," +
            "      \"bounds\": [" +
            "        {" +
            "          \"latitude\": 59.92559918218687," +
            "          \"longitude\": 10.760778486728668" +
            "        }," +
            "        {" +
            "          \"latitude\": 59.925603214545724," +
            "          \"longitude\": 10.76099306344986" +
            "        }," +
            "        {" +
            "          \"latitude\": 59.9256529469314," +
            "          \"longitude\": 10.760995745658873" +
            "        }," +
            "        {" +
            "          \"latitude\": 59.9257161203949," +
            "          \"longitude\": 10.760791897773741" +
            "        }," +
            "        {" +
            "          \"latitude\": 59.9256919263167," +
            "          \"longitude\": 10.760748982429503" +
            "        }," +
            "        {" +
            "          \"latitude\": 59.92568117338741," +
            "          \"longitude\": 10.76061487197876" +
            "        }," +
            "        {" +
            "          \"latitude\": 59.92559918218687," +
            "          \"longitude\": 10.760778486728668" +
            "        }" +
            "      ]" +
            "    }," +
            "    {" +
            "      \"id\": 191," +
            "      \"title\": \"Jakob kirke\"," +
            "      \"subtitle\": \"langs Torggata\"," +
            "      \"number_of_locks\": 9," +
            "      \"center\": {" +
            "        \"latitude\": 59.917879," +
            "        \"longitude\": 10.754906" +
            "      }," +
            "      \"bounds\": [" +
            "        {" +
            "          \"latitude\": 59.91771363912163," +
            "          \"longitude\": 10.7547327876091" +
            "        }," +
            "        {" +
            "          \"latitude\": 59.91789110461389," +
            "          \"longitude\": 10.755239725112913" +
            "        }," +
            "        {" +
            "          \"latitude\": 59.9180309252425," +
            "          \"longitude\": 10.755076110363005" +
            "        }," +
            "        {" +
            "          \"latitude\": 59.917846738329786," +
            "          \"longitude\": 10.754566490650177" +
            "        }," +
            "        {" +
            "          \"latitude\": 59.91771363912163," +
            "          \"longitude\": 10.7547327876091" +
            "        }" +
            "      ]" +
            "    }" +
            "  ]" +
            "}";





}