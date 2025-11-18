package api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import exception.ApiException;
import model.ConversionRequest;
import model.ConversionResponse;

public class ExchangeApi {

    private final String apiKey;
    private final String baseUrl = "https://v6.exchangerate-api.com/v6/"; 

    public ExchangeApi(String apiKey) {
        this.apiKey = apiKey;
    }
    
    public ConversionResponse callApi(ConversionRequest request) {

        String url = baseUrl + apiKey + "/pair/" 
                        + request.base() + "/" 
                        + request.target() + "/" 
                        + request.amount();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new ApiException("Error HTTP: " + response.statusCode());
            }

            Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().
                        create();
            
            return gson.fromJson(response.body(), ConversionResponse.class);

        } catch (IOException | InterruptedException e) {
            throw new ApiException("Error al comunicarse con la API: " + e.getMessage());
        }
    }
    
  

}
