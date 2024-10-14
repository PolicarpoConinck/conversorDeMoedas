package br.com.deconinck.currencyconverter.service;

import br.com.deconinck.currencyconverter.model.Currency;

import java.util.HashMap;
import java.util.Map;

public class CurrencyDatabase {
    private final Map<String, Currency> currencies; // Mapa para armazenar as moedas.

    public CurrencyDatabase() {
        currencies = new HashMap<>(); // Inicializa o mapa de moedas.
        initializeCurrencies(); // Chama o método para inicializar as moedas.
    }

    private void initializeCurrencies() { // Método para preencher o mapa com moedas.
        currencies.put("AUD", new Currency("AUD", "Australian Dollar"));
        currencies.put("ATS", new Currency("ATS", "Austrian Schilling"));
        currencies.put("BEF", new Currency("BEF", "Belgian Franc"));
        currencies.put("BRL", new Currency("BRL", "Brazilian Real"));
        currencies.put("CAD", new Currency("CAD", "Canadian Dollar"));
        currencies.put("CHF", new Currency("CHF", "Swiss Franc"));
        currencies.put("CNY", new Currency("CNY", "Chinese Yuan"));
        currencies.put("DEM", new Currency("DEM", "German Mark"));
        currencies.put("DKK", new Currency("DKK", "Danish Krone"));
        currencies.put("ESP", new Currency("ESP", "Spanish Peseta"));
        currencies.put("EUR", new Currency("EUR", "Euro"));
        currencies.put("FIM", new Currency("FIM", "Finnish Markka"));
        currencies.put("FRF", new Currency("FRF", "French Franc"));
        currencies.put("GBP", new Currency("GBP", "British Pound"));
        currencies.put("GRD", new Currency("GRD", "Greek Drachma"));
        currencies.put("HKD", new Currency("HKD", "Hong Kong Dollar"));
        currencies.put("IEP", new Currency("IEP", "Irish Pound"));
        currencies.put("INR", new Currency("INR", "Indian Rupee"));
        currencies.put("IRR", new Currency("IRR", "Iranian Rial"));
        currencies.put("ITL", new Currency("ITL", "Italian Lira"));
        currencies.put("JPY", new Currency("JPY", "Japanese Yen"));
        currencies.put("KRW", new Currency("KRW", "South Korean Won"));
        currencies.put("LKR", new Currency("LKR", "Sri Lankan Rupee"));
        currencies.put("MXN", new Currency("MXN", "Mexican Peso"));
        currencies.put("MYR", new Currency("MYR", "Malaysian Ringgit"));
        currencies.put("NOK", new Currency("NOK", "Norwegian Krone"));
        currencies.put("NLG", new Currency("NLG", "Dutch Florin"));
        currencies.put("NZD", new Currency("NZD", "New Zealand Dollar"));
        currencies.put("PTE", new Currency("PTE", "Portuguese Escudo"));
        currencies.put("SEK", new Currency("SEK", "Swedish Krona"));
        currencies.put("SGD", new Currency("SGD", "Singapore Dollar"));
        currencies.put("THB", new Currency("THB", "Thai Baht"));
        currencies.put("TWD", new Currency("TWD", "New Taiwan Dollar"));
        currencies.put("USD", new Currency("USD", "US Dollar"));
        currencies.put("ZAR", new Currency("ZAR", "South African Rand"));
    }

    public Map<String, Currency> getCurrencies() {
        return currencies; // Retorna o mapa de moedas.
    }
}
