package src.model;

public class Cocina {
    private final Ingredientes ingredientes;
    private final Horno horno;

    public Cocina(Ingredientes ingredientes, Horno horno) {
        this.ingredientes = ingredientes;
        this.horno = horno;

        if (ingredientes == null) {
            throw new IllegalArgumentException(
                "Debes indicar los ingredientes."
            );
        }

        if (horno == null) {
            throw new IllegalArgumentException(
                "Debes indicar un horno."
            );
        }
    }

    public Ingredientes getIngredientes() {
        return ingredientes;
    }

    public Horno getHorno() {
        return horno;
    }

    public void prepararPizza(Orden orden) {
        if (orden == null) {
            throw new IllegalArgumentException(
                "Debes indicar una orden."
            );
        }

        if (orden.isPreparada()) {
            throw new IllegalStateException(
                "La ordenesta preparada."
            );
        }

        if (orden.getPizza().isCocinada()) {
            throw new IllegalStateException(
                "La pizza se encuentra cocinada."
            );
        }

        if (!horno.estaListo()) {
            throw new IllegalStateException(
                "El horno no esta preparado."
            );
        }

        if (!orden.getCliente().puedePagar(orden.calcularTotal())) {
            throw new IllegalStateException(
                "El cliente no tiene suficiente cash."
            );
        }

        ingredientes.consumir(
                orden.getPizza(),
                orden.getCantidadPizzas()
        );

        horno.hornearPizza(orden.getPizza());

        orden.marcarPreparada();
    }

    @Override
    public String toString() {
        return "Cocina:"
                + "\n" + ingredientes
                + "\n" + horno;
    }
}