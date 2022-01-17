package ua.ithillel.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RandomHTTPService {
    public Integer getNumber(int min, int max) {

        try {
            HttpRequest httpRequest = HttpRequest.newBuilder(new URI("http://www.randomnumberapi.com/api/v1.0/random?min=" + min + "&max=" + max + "&count=1"))
                    .GET()
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            String str = (response.body().substring(1, response.body().length() - 1));
            return Integer.parseInt(str);

        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
