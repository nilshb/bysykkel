package bysykkel.client.availability;

import bysykkel.client.BysykkelRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class AvailabilityClient {

    private static final String PATH = "/stations/availability";

    private Gson gson = new Gson();
    private BysykkelRequest bysykkelRequest;

    public AvailabilityClient(String authToken) {
        bysykkelRequest = new BysykkelRequest(authToken);
    }

    public List<StationAvailability> findStationsAvailability() {
        JsonObject jsonObject = gson.fromJson(bysykkelRequest.doRequest(PATH), JsonObject.class);

        return gson.fromJson((jsonObject.get("stations")), new TypeToken<ArrayList<StationAvailability>>(){}.getType());
    }
}
