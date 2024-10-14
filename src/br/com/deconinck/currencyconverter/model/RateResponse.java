package br.com.deconinck.currencyconverter.model;

import java.util.Map;

public class RateResponse {
    private Map<String, Double> conversionRates; // Mapa para armazenar as taxas de conversão.

    public Map<String, Double> getConversionRates() {
        return conversionRates; // Método para obter as taxas de conversão.
    }
}
