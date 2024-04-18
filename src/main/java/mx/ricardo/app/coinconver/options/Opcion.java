package mx.ricardo.app.coinconver.options;

public class Opcion {

    public  CompraVenta obtenerCompraVenta(int option) {
        String compra = "";
        String venta = "";

        switch (option) {
            case 1:
                compra = "USD";
                venta = "MXN";
                break;
            case 2:
                compra = "MXN";
                venta = "USD";
                break;
            case 3:
                compra = "USD";
                venta = "BRL";
                break;
            case 4:
                compra = "BRL";
                venta = "USD";
                break;
            case 5:
                compra = "USD";
                venta = "COP";
                break;
            case 6:
                compra = "COP";
                venta = "USD";
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }

        return new CompraVenta(compra, venta);
    }

    public static class CompraVenta {
        private String compra;
        private String venta;

        public CompraVenta(String compra, String venta) {
            this.compra = compra;
            this.venta = venta;
        }

        public String getCompra() {
            return compra;
        }

        public String getVenta() {
            return venta;
        }
    }
}
