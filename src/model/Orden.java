package src.model;

public class Orden {
    private final Cliente cliente;
    private final Pizza pizza;
    private final int cantidadPizzas;
    private final int precioUnitarioCentavos;
    private boolean preparada;
    private boolean pagada;

    public Orden(Cliente cliente, Pizza pizza, int cantidadPizzas,
                 int precioUnitarioCentavos) {

        this.cliente = cliente;
        this.pizza = pizza;
        this.cantidadPizzas = cantidadPizzas;
        this.precioUnitarioCentavos = precioUnitarioCentavos;
        this.preparada = false;
        this.pagada = false;

        if (cliente == null) {
            throw new IllegalArgumentException(
                "Debes indicar un cliente."
            );
        }

        if (pizza == null) {
            throw new IllegalArgumentException(
                "Debes indicar una pizza."
            );
        }

        if (pizza.isCocinada()) {
            throw new IllegalArgumentException(
                "La pizza debe estar sin cocinar."
            );
        }

        if (cantidadPizzas <= 0) {
            throw new IllegalArgumentException(
                "La cantidad de pizzas debe ser mayor que cero."
            );
        }

        if (precioUnitarioCentavos <= 0) {
            throw new IllegalArgumentException(
                "El precio debe ser mayor que cero."
            );
        }

        if ((long) cantidadPizzas * precioUnitarioCentavos
                > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(
                "El total de la orden es demasiado grande."
            );
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public int getCantidadPizzas() {
        return cantidadPizzas;
    }

    public int getPrecioUnitarioCentavos() {
        return precioUnitarioCentavos;
    }

    public boolean isPreparada() {
        return preparada;
    }

    public boolean isPagada() {
        return pagada;
    }

    public int calcularTotal() {
        return cantidadPizzas * precioUnitarioCentavos;
    }

    void marcarPreparada() {
        if (!pizza.isCocinada()) {
            throw new IllegalStateException(
                "Primero debes cocinar la pizza."
            );
        }

        preparada = true;
    }

    public void cobrar() {
        if (!preparada) {
            throw new IllegalStateException(
                "La orden todavia no esta preparada."
            );
        }

        if (pagada) {
            throw new IllegalStateException(
                "La orden ya fue pagada."
            );
        }

        cliente.pagar(calcularTotal());
        pagada = true;
    }

    public String factura() {
        if (!pagada) {
            throw new IllegalStateException(
                "Primero debes pagar la orden."
            );
        }

        return "----- COMPROBANTE -----"
                + "\nCliente: " + cliente.getNombre()
                + "\nPizza: " + pizza.getTipoToppings()
                + "\nCantidad: " + cantidadPizzas
                + "\nPrecio por pizza: Q"
                + String.format(java.util.Locale.ROOT,
                        "%.2f", precioUnitarioCentavos / 100.0)
                + "\nTotal: Q"
                + String.format(java.util.Locale.ROOT,
                        "%.2f", calcularTotal() / 100.0);
    }

    @Override
    public String toString() {
        return "Orden de: " + cliente.getNombre()
                + " | Pizza: " + pizza.getTipoToppings()
                + " | Cantidad: " + cantidadPizzas
                + " | Preparada: " + preparada
                + " | Pagada: " + pagada;
    }
}