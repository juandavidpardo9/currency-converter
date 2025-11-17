package main;

import service.CurrencyService;

public class App {
    public static void main(String[] args) throws Exception {

        String apiKey = "";

        CurrencyService service = new CurrencyService(apiKey);

        double result = service.convert("USD", "COP", 1);

        System.out.println("Resultado: " + result);
    }
}
