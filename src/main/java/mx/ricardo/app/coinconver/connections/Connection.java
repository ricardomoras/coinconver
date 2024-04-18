package mx.ricardo.app.coinconver.connections;

import com.google.gson.Gson;
import mx.ricardo.app.coinconver.entities.ForeingExchange;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connection {

    public ForeingExchange findCurrency(String coin){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/a7e2f0427961f1dcd1fe02fa/latest/"+coin);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ForeingExchange.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre la ruta");
        }

    }
}
