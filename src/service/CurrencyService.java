package service;

import api.ExchangeApi;
import model.ConversionRequest;
import model.ConversionResponse;

public class CurrencyService {

    private final ExchangeApi apiClient;

    // Recibe la API key y crea el cliente correctamente
    public CurrencyService(String apiKey) {
        this.apiClient = new ExchangeApi(apiKey);
    }

    public double convert(String base, String target, double amount) {
        ConversionRequest request = new ConversionRequest(base, target, amount);
        ConversionResponse response = apiClient.callApi(request);
        return response.conversionResult();
    }

}
