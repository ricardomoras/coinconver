package mx.ricardo.app.coinconver.entities;

import java.util.Map;

public record ForeingExchange(String base_code,
                              Map<String, Float > conversion_rates) {
}
