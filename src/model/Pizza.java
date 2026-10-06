package src.model;

public class Pizza {
    private final String tipoMasa;
    private final String tipoSalsa;
    private final String tipoTopping;
    private final int cantidadPorciones;
    private final String tipoQueso;
    private boolean cocinada;

    public Pizza(String tipoMasa, String tipoSalsa, String tipoTopping,
                 int cantidadPorciones, String tipoQueso) {

        this.tipoMasa = tipoMasa;
        this.tipoSalsa = tipoSalsa;
        this.tipoTopping = tipoTopping;
        this.cantidadPorciones = cantidadPorciones;
        this.cocinada = false;

        if (tipoMasa == null || tipoMasa.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Indicar tipo de masa."
            );
        }

        if (tipoSalsa == null || tipoSalsa.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Indicar tipo de salsa."
            );
        }

        if (tipoQueso == null || tipoQueso.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Indicar tipo de queso."
            );
        }

        if (cantidadPorciones <= 0) {
            throw new IllegalArgumentException(
                "Las porciones deben ser mayores que cero."
            );
        }

        if (!"Jamon".equals(tipoTopping)
                && !"Pepperoni".equals(tipoTopping)
                && !"Vegetales".equals(tipoTopping)
                && !"Salami".equals(tipoTopping)
                && !"Sin queso".equals(tipoTopping)
                && !"Salami y jamon".equals(tipoTopping)
                && !"Tres quesos".equals(tipoTopping)) {

            throw new IllegalArgumentException(
                "Ese sabor no esta disponible."
            );
        }

        if ("Sin queso".equals(tipoTopping)) {
            this.tipoQueso = "Sin queso";
        } else if ("Tres quesos".equals(tipoTopping)) {
            this.tipoQueso = "Mozzarella, cheddar y parmesano";
        } else {
            this.tipoQueso = tipoQueso;
        }
    }

    public String getTipoMasa() {
        return tipoMasa;
    }

    public String getTipoSalsa() {
        return tipoSalsa;
    }

    public String getTipoToppings() {
        return tipoTopping;
    }

    public int getCantidadPorciones() {
        return cantidadPorciones;
    }

    public String getTipoQueso() {
        return tipoQueso;
    }

    public boolean isCocinada() {
        return cocinada;
    }

    void marcarCocinada() {
        cocinada = true;
    }

    @Override
    public String toString() {
        return "Pizza de " + tipoTopping
                + " | Masa: " + tipoMasa
                + " | Salsa: " + tipoSalsa
                + " | Queso: " + tipoQueso
                + " | Porciones: " + cantidadPorciones
                + " | Cocinada: " + cocinada;
    }
}