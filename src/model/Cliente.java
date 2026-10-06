package src.model;

public class Cliente {
    private final String nombre;
    private boolean hambriento;
    private int dineroCentavos;

    public Cliente(String nombre, int dineroCentavos) {
        this.nombre = nombre;
        this.dineroCentavos = dineroCentavos;
        this.hambriento = true;

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Debes indicar el nombre del cliente."
            );
        }

        if (dineroCentavos < 0) {
            throw new IllegalArgumentException(
                "El dinero no puede ser negativo."
            );
        }
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isHambriento() {
        return hambriento;
    }

    public int getDineroCentavos() {
        return dineroCentavos;
    }

    public boolean puedePagar(int total) {
        return total > 0 && dineroCentavos >= total;
    }

    public void pagar(int total) {
        if (total <= 0) {
            throw new IllegalArgumentException(
                "El total debe ser mayor que cero."
            );
        }

        if (!puedePagar(total)) {
            throw new IllegalStateException(
                "El cliente no tiene suficiente dinero."
            );
        }

        dineroCentavos -= total;
    }

    public void comer(Orden orden) {
        if (orden == null) {
            throw new IllegalArgumentException(
                "Indicar una orden."
            );
        }

        if (orden.getCliente() != this) {
            throw new IllegalStateException(
                "La orden es de otro cliente."
            );
        }

        if (!orden.isPreparada() || !orden.isPagada()) {
            throw new IllegalStateException(
                "La orden tiene que estar preparada y ya pagada."
            );
        }

        hambriento = false;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre
                + " | Hambriento: " + hambriento
                + " | Dinero en centavos: " + dineroCentavos;
    }
}