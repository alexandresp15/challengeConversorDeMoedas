import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main (String[] args) {

        var baseCurrency = "USD";
        var targetCurrency = "BRL";
        var apiKey = "c9ac2cedfa959c28352d38f6";
        var url = "https://v6.exchangerate-api.com/v6/"
                + apiKey + "/latest/" + baseCurrency;

        try {
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            var response = client.
                    send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status HTTP: " + response.statusCode());

            if( response.statusCode() != 200) {
                System.out.println("Erro na requisição");
                System.out.println(response.body());
                return;
            }
            String body = response.body();

            JsonElement parsed = JsonParser.parseString(body);
            JsonObject root = parsed.getAsJsonObject();
            JsonObject rates = root.getAsJsonObject("conversion_rates");
            double rate = rates.get(targetCurrency).getAsDouble();
            System.out.printf("1 %s = %.6f %s%n",
                    baseCurrency, rate, targetCurrency);

            double amountUsd = 100.0;
            double converted = amountUsd * rate;
            System.out.printf("%.2f %s = %.2f %s%n",
                    amountUsd, baseCurrency, converted, targetCurrency);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
