package mx.ricardo.app.coinconver;

import mx.ricardo.app.coinconver.menu.TextInMenu;
import mx.ricardo.app.coinconver.operations.OperationCurrency;
import mx.ricardo.app.coinconver.options.OptionsSelector;

import java.util.Scanner;

public class AppCoinConver {

    /**
     * Método principal que inicia la ejecución de la aplicación.
     *
     * Este método muestra un menú de opciones al usuario para seleccionar el tipo de conversión de moneda.
     * Luego, solicita al usuario que ingrese el valor a convertir y realiza la conversión utilizando
     * la clase OperationCurrency y la clase OptionsSelector. Finalmente, muestra el resultado de la conversión.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        // Creación de un objeto Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);

        // Inicialización de variables
        int menu1 = 0;
        OperationCurrency operation = new OperationCurrency();
        OptionsSelector opcion = new OptionsSelector();
        TextInMenu menu = new TextInMenu();

        // Bucle para mostrar el menú y procesar las opciones del usuario
        while (menu1 != 7) {
            try {
            // Mostrar el menú de opciones al usuario
            System.out.println(menu.getLetra());
            menu1 = sc.nextInt();

            // Procesar la opción seleccionada por el usuario
            if (menu1 >= 1 && menu1 <= 6 ) {
                // Obtener las monedas de compra y venta seleccionadas
                String buy = opcion.chooseAnOption(menu1).getBuy();
                String sell = opcion.chooseAnOption(menu1).getSell();

                // Solicitar al usuario que ingrese el valor a convertir
                System.out.println("Ingrese el valor que desea convertir:");
                Float amount = sc.nextFloat();

                // Realizar la conversión de moneda
                Float conversion = operation.CurrencyConversion(amount,sell,buy);

                // Formatear y mostrar el resultado de la conversión
                String mensaje = String.format("""
                        El valor %.1f [%s] corresponde al valor final de =>>> %.2f [%s]
                        \n""", amount, buy, conversion, sell);

                System.out.println(mensaje);

            } else if (menu1 == 7){
                // Salir de la aplicación si se selecciona la opción 7
                System.out.println("Adios");
            } else {
                // Mostrar un mensaje de error si se selecciona una opción inválida
                System.out.println("Selecciones una opcion valida");
            }
        } catch (Exception e){

                // Capturar y manejar excepciones si se introducen valores no válidos
                System.out.println("Solo debe poner numeros del 1 al 7");
                break;
            }
        }
    }
}
