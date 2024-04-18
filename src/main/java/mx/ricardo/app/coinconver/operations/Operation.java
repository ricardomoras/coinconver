package mx.ricardo.app.coinconver.operations;

import mx.ricardo.app.coinconver.connections.Connection;

import java.util.Map;

public class Operation {
    Connection consulta = new Connection();
    public Float dolarToPesoMexicano(Float monto,String coin, String coin2){
        Map<String, Float> mapa = consulta.findCurrency(coin).conversion_rates();
        return monto / mapa.get(coin2);
    }
}
