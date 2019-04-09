package bysykkel.client.station;


import bysykkel.client.BysykkelRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class StationClient {

    private static final String PATH = "/stations";

    private Gson gson = new Gson();
    private BysykkelRequest bysykkelRequest;

    public StationClient(String authToken) {
        bysykkelRequest = new BysykkelRequest(authToken);
    }


    public List<Station> findStations() {
        JsonObject jsonObject = gson.fromJson(bysykkelRequest.doRequest(PATH), JsonObject.class);

        return gson.fromJson((jsonObject.get("stations")), new TypeToken<ArrayList<Station>>(){}.getType());
    }

}
