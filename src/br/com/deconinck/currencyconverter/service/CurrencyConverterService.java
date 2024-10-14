package br.com.deconinck.currencyconverter.service;

import br.com.deconinck.currencyconverter.model.Currency;
import br.com.deconinck.currencyconverter.service.CurrencyDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class CurrencyConverterService {
    private final CurrencyDatabase currencyDatabase; // Base de dados de moedas.
    private final String apiKey = "48ad3691ac9112f8dba52fb8"; // Chave da API para obter taxas de câmbio.

    public CurrencyConverterService() {
        this.currencyDatabase = new CurrencyDatabase(); // Inicializa a base de dados de moedas.
    }

    public double convertCurrency(String baseCurrency, String targetCurrency, double amount) throws IOException, InterruptedException {
        String baseUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency; // URL da API para obter taxas de câmbio.
        HttpClient client = HttpClient.newHttpClient(); // Cria um cliente HTTP.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl)) // Cria a solicitação HTTP para a URL da API.
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // Envia a solicitação e obtém a resposta.

        // Verifica se a resposta foi bem-sucedida.
        if (response.statusCode() != 200) {
            throw new IOException("Failed to fetch exchange rate: " + response.body()); // Lança exceção se a resposta não for 200.
        }

        // Analisa a resposta JSON para obter as taxas de câmbio.
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Cria um objeto Gson para análise de JSON.
        Map<String, Object> responseData = gson.fromJson(response.body(), Map.class); // Converte a resposta JSON em um mapa.
        Map<String, Double> rates = (Map<String, Double>) responseData.get("conversion_rates"); // Obtém as taxas de conversão.

        // Realiza a conversão.
        double exchangeRate = rates.getOrDefault(targetCurrency, 0.0); // Obtém a taxa de câmbio ou 0 se não encontrada.
        return amount * exchangeRate; // Retorna o valor convertido.
    }

    public Map<String, Currency> getCurrencies() {
        return currencyDatabase.getCurrencies(); // Retorna o mapa de moedas disponíveis.
    }
}
