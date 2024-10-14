package br.com.deconinck.currencyconverter.history;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConversionHistory {
    private final List<String> conversionHistoryList; // Lista para armazenar o histórico de conversões.

    public ConversionHistory() { // Construtor que inicializa a lista.
        this.conversionHistoryList = new ArrayList<>();
    }

    public void addConversion(String conversion) { // Adiciona uma conversão ao histórico.
        conversionHistoryList.add(conversion);
    }

    public void displayHistory() { // Exibe o histórico de conversões.
        if (conversionHistoryList.isEmpty()) {
            System.out.println("No conversions have been made yet.");
        } else {
            for (String entry : conversionHistoryList) {
                System.out.println(entry);
            }
        }
    }

    public void addConversionWithTimestamp(double amount, String baseCurrency, double convertedAmount, String targetCurrency) {
        String timestamp = new SimpleDateFormat("dd/MM/yyyy - HH:mm").format(new Date()); // Obtém a data atual formatada.
        // Formata a string da conversão.
        String conversionEntry = String.format("Date: %s - Value: %.2f %s = %.2f %s", timestamp, amount, baseCurrency, convertedAmount, targetCurrency);
        addConversion(conversionEntry); // Adiciona a entrada formatada ao histórico.
    }
}
