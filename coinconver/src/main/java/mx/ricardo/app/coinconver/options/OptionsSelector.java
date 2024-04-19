package mx.ricardo.app.coinconver.options;

public class OptionsSelector {

    /**
     * Método que elige una opción de conversión de moneda basada en el número seleccionado.
     *
     * @param option Número de opción seleccionada por el usuario.
     * @return Objeto typesOfOperation con las monedas de compra y venta seleccionadas.
     */
    public  typesOfOperation chooseAnOption(int option) {
        // Variables para almacenar las monedas de compra y venta
        String buy = "";
        String sell = "";

        // Switch para determinar las monedas de compra y venta según la opción seleccionada
        switch (option) {
            case 1:
                buy = "USD";
                sell = "MXN";
                break;
            case 2:
                buy = "MXN";
                sell = "USD";
                break;
            case 3:
                buy = "USD";
                sell = "BRL";
                break;
            case 4:
                buy = "BRL";
                sell = "USD";
                break;
            case 5:
                buy = "USD";
                sell = "COP";
                break;
            case 6:
                buy = "COP";
                sell = "USD";
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
        // Devuelve un objeto typesOfOperation con las monedas de compra y venta seleccionadas
        return new typesOfOperation(buy, sell);
    }

    /**
     * Clase interna que representa las monedas de compra y venta seleccionadas.
     */
    public static class typesOfOperation {
        private String buy;
        private String sell;

        /**
         * Constructor de la clase typesOfOperation.
         *
         * @param compra Moneda de compra.
         * @param venta Moneda de venta.
         */
        public typesOfOperation(String compra, String venta) {
            this.buy = compra;
            this.sell = venta;
        }

        /**
         * Método para obtener la moneda de compra.
         *
         * @return Moneda de compra.
         */
        public String getBuy() {
            return buy;
        }

        /**
         * Método para obtener la moneda de venta.
         *
         * @return Moneda de venta.
         */
        public String getSell() {
            return sell;
        }
    }
}
