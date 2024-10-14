package br.com.deconinck.currencyconverter.model;

public record Currency(String code, String description) {}


/*
Esta classe usa o recurso de record introduzido no Java 14, que é uma forma concisa de criar classes que apenas transportam dados.
br.com.deconinck.currencyconverter.model.Currency armazena um código da moeda (por exemplo, "USD") e sua descrição (por exemplo, "Dólar Americano")
 */