package mx.ricardo.app.coinconver;

import mx.ricardo.app.coinconver.connections.Connection;
import mx.ricardo.app.coinconver.entities.ForeingExchange;
import mx.ricardo.app.coinconver.menu.Menu;
import mx.ricardo.app.coinconver.operations.Operation;
import mx.ricardo.app.coinconver.options.Opcion;

import java.util.Map;
import java.util.Scanner;

public class AppCoinConver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Operation operation = new Operation();
        Opcion opcion = new Opcion();
        int menu1 = 0;
        Menu menu = new Menu();

        while (menu1 != 7) {
            System.out.println(menu.getLetra());
            menu1 = sc.nextInt();
            if (menu1 >= 1 && menu1 <= 6 ) {
                String compra = opcion.obtenerCompraVenta(menu1).getCompra();
                String venta = opcion.obtenerCompraVenta(menu1).getVenta();
                System.out.println("Ingrese el valor que desea convertir:");
                Float monto = sc.nextFloat();
                Float tipo = operation.dolarToPesoMexicano(monto,venta,compra);

                String mensaje = String.format("El valor %.1f %s corresponde al valor final =>>> %.2f [%s]", monto, compra, tipo, venta);

                System.out.println(mensaje);

            } else if (menu1 == 7){
                System.out.println("Adios");
            } else {
                System.out.println("Selecciones una opcion valida");
            }
        }
    }
}
