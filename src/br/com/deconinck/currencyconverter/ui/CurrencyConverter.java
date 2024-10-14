package br.com.deconinck.currencyconverter.ui;

import br.com.deconinck.currencyconverter.history.ConversionHistory;
import br.com.deconinck.currencyconverter.model.Currency;
import br.com.deconinck.currencyconverter.service.CurrencyConverterService;

import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private final CurrencyConverterService service; // Serviço que realiza a conversão de moedas.
    private final ConversionHistory history; // Histórico das conversões.

    public CurrencyConverter() {
        service = new CurrencyConverterService(); // Inicializa o serviço de conversão.
        history = new ConversionHistory(); // Inicializa o histórico de conversões.
    }

    public void start() {
        Scanner scanner = new Scanner(System.in); // Cria um scanner para ler a entrada do usuário.
        while (true) {
            try {
                System.out.println("Choose an option:");
                System.out.println("1. Convert currency");
                System.out.println("2. View conversion history");
                System.out.println("3. List available currencies");
                System.out.println("4. Exit");
                int choice = Integer.parseInt(scanner.nextLine()); // Lê a opção do usuário.

                switch (choice) {
                    case 1: // Opção para converter moeda.
                        convertCurrency(scanner);
                        break;
                    case 2: // Opção para exibir histórico de conversões.
                        history.displayHistory();
                        break;
                    case 3: // Opção para listar moedas disponíveis.
                        listCurrencies();
                        break;
                    case 4: // Opção para sair do programa.
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage()); // Exibe erro caso ocorra.
            }
        }
    }

    private void convertCurrency(Scanner scanner) { // Método para realizar a conversão de moedas.
        try {
            System.out.print("Enter the base currency (e.g., BRL): ");
            String baseCurrency = scanner.nextLine().toUpperCase(); // Lê a moeda base.
            System.out.print("Enter the target currency (e.g., USD): ");
            String targetCurrency = scanner.nextLine().toUpperCase(); // Lê a moeda alvo.
            System.out.print("Enter the amount to be converted: ");
            double amount = Double.parseDouble(scanner.nextLine()); // Lê o valor a ser convertido.

            double convertedAmount = service.convertCurrency(baseCurrency, targetCurrency, amount); // Realiza a conversão.
            history.addConversionWithTimestamp(amount, baseCurrency, convertedAmount, targetCurrency); // Adiciona ao histórico.
            System.out.printf("%.2f %s = %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency); // Exibe o resultado da conversão.
        } catch (Exception e) {
            System.out.println("Error in conversion: " + e.getMessage()); // Exibe erro caso ocorra.
        }
    }

    private void listCurrencies() { // Método para listar moedas disponíveis.
        Map<String, Currency> currencies = service.getCurrencies(); // Obtém as moedas do serviço.
        for (Currency currency : currencies.values()) {
            System.out.println(currency); // Exibe cada moeda.
        }
    }
}
