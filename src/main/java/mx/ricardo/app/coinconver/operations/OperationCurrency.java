package mx.ricardo.app.coinconver.operations;

import mx.ricardo.app.coinconver.connections.Connection;
import java.util.Map;

public class OperationCurrency {
    // Instancia de la clase Connection para realizar consultas
    Connection consulta = new Connection();

    /**
     * Método que realiza la conversión de moneda.
     *
     * @param amount Cantidad de dinero a convertir.
     * @param buy   Moneda de origen.
     * @param sell  Moneda de destino.
     * @return Cantidad convertida a la moneda de destino.
     */
    public Float CurrencyConversion(Float amount, String buy, String sell){

        // Obtiene el mapa de tasas de conversión de la moneda de origen
        Map<String, Float> mapa = consulta.findCurrency(buy).conversion_rates();

        // Realiza la conversión de moneda
        return amount / mapa.get(sell);
    }
}
