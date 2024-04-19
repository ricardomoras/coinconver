package mx.ricardo.app.coinconver.entities;

import java.util.Map;

// Clase para mapear el Json del API
public record ForeignExchange(Map<String, Float > conversion_rates) {
}
