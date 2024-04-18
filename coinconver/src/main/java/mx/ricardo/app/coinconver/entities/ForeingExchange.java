package mx.ricardo.app.coinconver.entities;

import java.util.Map;

public record ForeingExchange(Map<String, Float > conversion_rates) {
}
