package main;

import service.CurrencyService;
import ui.Menu;

public class App {
    public static void main(String[] args) throws Exception {

        String apiKey = "";

        CurrencyService service = new CurrencyService(apiKey);

        Menu menu = new Menu(service);
        menu.iniciar();
    }
}
