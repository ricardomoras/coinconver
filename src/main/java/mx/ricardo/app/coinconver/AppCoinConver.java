package mx.ricardo.app.coinconver;

import mx.ricardo.app.coinconver.connections.Connection;
import mx.ricardo.app.coinconver.entities.ForeingExchange;

import java.io.IOException;
import java.util.Scanner;

public class AppCoinConver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Connection consulta = new Connection();
        System.out.println("Escriba el tipo de cambio");
        try {
            String divisa = sc.next();
            ForeingExchange foreing = consulta.findCurrency(divisa);
            System.out.println(foreing);
        } catch (NumberFormatException e){
            System.out.println("Numero no encontrado");
        } catch (RuntimeException  e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicacion");
        }
    }
}
