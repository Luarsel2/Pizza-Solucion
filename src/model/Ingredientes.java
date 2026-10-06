package src.model;

public class Ingredientes {
    private int stockJamon;
    private int stockPepperoni;
    private int stockMasa;
    private int stockSalsa;
    private int stockVegetales;
    private int stockQueso;
    private int stockSalami;

    public Ingredientes(int stockJamon, int stockPepperoni, int stockMasa, int stockSalsa, int stockVegetales, int stockQueso, int stockSalami) {
        this.stockJamon = stockJamon;
        this.stockPepperoni = stockPepperoni;
        this.stockMasa = stockMasa;
        this.stockSalsa = stockSalsa;
        this.stockVegetales = stockVegetales;
        this.stockQueso = stockQueso;
        this.stockSalami = stockSalami;

        if (stockJamon < 0 || stockPepperoni < 0
                || stockMasa < 0 || stockSalsa < 0
                || stockVegetales < 0 || stockQueso < 0
                || stockSalami < 0) {

            throw new IllegalArgumentException(
                "Cantidad ingredientes no puede ser negativa."
            );
        }
    }

    public boolean hayStock(Pizza pizza, int cantidad) {
        if (pizza == null || cantidad <= 0) {
            throw new IllegalArgumentException(
                "Indicar pizza y la cantidad mayor que cero."
            );
        }

        if (stockMasa < cantidad || stockSalsa < cantidad) {
            return false;
        }

        if (stockQueso < (long) quesoPorPizza(pizza) * cantidad) {
            return false;
        }

        switch (pizza.getTipoToppings()) {
            case "Jamon":
                return stockJamon >= cantidad;

            case "Pepperoni":
                return stockPepperoni >= cantidad;

            case "Vegetales":
                return stockVegetales >= cantidad;

            case "Salami":
                return stockSalami >= cantidad;

            case "Salami y jamon":
                return stockSalami >= cantidad
                        && stockJamon >= cantidad;

            case "Sin queso":
            case "Tres quesos":
                return true;

            default:
                return false;
        }
    }

    public void consumir(Pizza pizza, int cantidad) {
        if (!hayStock(pizza, cantidad)) {
            throw new IllegalStateException(
                "No hay suficientes ingredientes."
            );
        }

        stockMasa -= cantidad;
        stockSalsa -= cantidad;
        stockQueso -= quesoPorPizza(pizza) * cantidad;

        switch (pizza.getTipoToppings()) {
            case "Jamon":
                stockJamon -= cantidad;
                break;

            case "Pepperoni":
                stockPepperoni -= cantidad;
                break;

            case "Vegetales":
                stockVegetales -= cantidad;
                break;

            case "Salami":
                stockSalami -= cantidad;
                break;

            case "Salami y jamon":
                stockSalami -= cantidad;
                stockJamon -= cantidad;
                break;

            case "Sin queso":
            case "Tres quesos":
                break;
        }
    }

    private int quesoPorPizza(Pizza pizza) {
        if ("Sin queso".equals(pizza.getTipoToppings())) {
            return 0;
        }

        if ("Tres quesos".equals(pizza.getTipoToppings())) {
            return 3;
        }

        return 1;
    }

    @Override
    public String toString() {
        return "Ingredientes disponibles:"
                + " | Jamon: " + stockJamon
                + " | Pepperoni: " + stockPepperoni
                + " | Masa: " + stockMasa
                + " | Salsa: " + stockSalsa
                + " | Vegetales: " + stockVegetales
                + " | Queso: " + stockQueso
                + " | Salami: " + stockSalami;
    }
}