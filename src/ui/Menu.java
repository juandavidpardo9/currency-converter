package ui;

import java.util.Scanner;

import service.CurrencyService;

public class Menu {

    private final CurrencyService service;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(CurrencyService service) {
        this.service = service;
    }

    public void iniciar() {

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("*****************************************************");
            System.out.println("Sea bienvenido/a al conversor de Moneda =]");
            System.out.println("1. Dólar -> Peso argentino");
            System.out.println("2. Peso argentino -> Dólar");
            System.out.println("3. Dólar -> Real brasileño");
            System.out.println("4. Real brasileño -> Dólar");
            System.out.println("5. Dólar -> Peso colombiano");
            System.out.println("6. Peso colombiano -> Dólar");
            System.out.println("7. Salir ");
            System.out.println("*****************************************************");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> menuConvert("USD", "ARS");
                case 2 -> menuConvert("ARS", "USD");
                case 3 -> menuConvert("USD", "BRL");
                case 4 -> menuConvert("BRL", "USD");
                case 5 -> menuConvert("USD", "COP");
                case 6 -> menuConvert("COP", "USD");
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }

            System.out.println();
        }
    }

    private void menuConvert(String base, String target) {
        System.out.print("Ingrese el monto a convertir: ");

        double amount = Double.parseDouble(scanner.nextLine());

        try {
            var result = service.convert(base, target, amount);
            System.out.println("*****************************************************");
            System.out.println("El valor " + amount + " ["+base+"] "+"corresponde al valor final de --> "+result+" ["+target+"] ");

        } catch (Exception e) {
            System.out.println("Error al convertir: " + e.getMessage());
        }
    }
}
