import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.lang.String.format;

public class Main {
    public static void main(String[] args) {
        String x_Yandex_Weather_Key = "0cb02a21-c8dc-42d1-869a-529e9984ef10";
        int lat = (int) 53.2521;
        int lon = (int) 34.3717;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(format("https://api.weather.yandex.ru/v2/forecast?%.75&lon=37.62")))
                .GET()
                .header(x_Yandex_Weather_Key ,"application/json")
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (Exception e) {
            System.err.println("Error making HTTP request: " + e.getMessage());
        }

    }
}
