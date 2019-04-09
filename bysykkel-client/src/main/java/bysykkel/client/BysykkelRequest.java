package bysykkel.client;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class BysykkelRequest {

    private static final String BASE_URL = "https://oslobysykkel.no/api/v1";

    private final String authToken;
    private OkHttpClient client = new OkHttpClient();

    public BysykkelRequest(String authToken) {

        this.authToken = authToken;
    }

    public String doRequest(String path) {
        String body;
        try {
            Response response = client.newCall(getRequest(path)).execute();
            if (!response.isSuccessful()) throw new BysykkelClientException("response from server: " + response);
            body = response.body() == null ? null : response.body().string();
        } catch (IOException ioe) {
            throw new BysykkelClientException(ioe.getMessage());
        }

        return body;
    }

    private Request getRequest(String path) {
        return new Request.Builder()
                .header("Client-Identifier", authToken)
                .url(BASE_URL + path)
                .build();
    }
}
