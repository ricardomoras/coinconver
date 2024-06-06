package mx.ricardo.app.coinconver.connections;

import com.google.gson.Gson;
import mx.ricardo.app.coinconver.entities.ForeignExchange;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connection {

    /**
     * Método que realiza una consulta a la API para obtener las tasas de cambio de una moneda específica.
     *
     * @param coin Moneda para la cual se desea obtener las tasas de cambio.
     * @return Objeto ForeignExchange con las tasas de cambio.
     * @throws RuntimeException Si no se puede establecer la conexión o la ruta no es válida.
     */
    public ForeignExchange findCurrency(String coin){
        // Creación de la URI para la consulta a la API
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/key/latest/"+coin);

        // Creación de un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Construcción de la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        try {
            // Envío de la solicitud y obtención de la respuesta
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Deserialización de la respuesta JSON a un objeto ForeingExchange
            return new Gson().fromJson(response.body(), ForeignExchange.class);
        } catch (Exception e) {

            // Lanzamiento de una excepción en caso de error
            throw new RuntimeException("No encontre la ruta");
        }

    }
}
