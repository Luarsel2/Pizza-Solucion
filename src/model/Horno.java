package src.model;

public class Horno {
    private boolean estaEncendido;
    private boolean tieneGas;
    private double temperatura;
    private int tiempoCoccion;

    public Horno(boolean tieneGas) {
        this.tieneGas = tieneGas;
        this.estaEncendido = false;
        this.temperatura = 0;
        this.tiempoCoccion = 0;
    }

    public boolean isEstaEncendido() {
        return estaEncendido;
    }

    public boolean isTieneGas() {
        return tieneGas;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public int getTiempoCoccion() {
        return tiempoCoccion;
    }

    public void encender(double temperatura) {
        if (!tieneGas) {
            throw new IllegalStateException(
                "El horno no tiene gas."
            );
        }

        if (!Double.isFinite(temperatura) || temperatura <= 0) {
            throw new IllegalArgumentException(
                "Temperatura debe ser mayor que cero."
            );
        }

        this.temperatura = temperatura;
        this.estaEncendido = true;
    }

    public void definirTiempo(int minutos) {
        if (minutos <= 0) {
            throw new IllegalArgumentException(
                "Tiempo debe ser mayor que cero."
            );
        }

        this.tiempoCoccion = minutos;
    }

    public boolean estaListo() {
        return estaEncendido && tieneGas
                && temperatura > 0 && tiempoCoccion > 0;
    }

    public void hornearPizza(Pizza pizza) {
        if (pizza == null) {
            throw new IllegalArgumentException(
                "Indica una pizza."
            );
        }

        if (pizza.isCocinada()) {
            throw new IllegalStateException(
                "La pizza cocinada!"
            );
        }

        if (!estaListo()) {
            throw new IllegalStateException(
                "El horno tiene q estar encendido y tener temperatura y tiempo."
            );
        }

        pizza.marcarCocinada();
    }

    @Override
    public String toString() {
        return "Horno:"
                + " | Encendido: " + estaEncendido
                + " | Tiene gas: " + tieneGas
                + " | Temperatura: " + temperatura
                + " | Tiempo en minutos: " + tiempoCoccion;
    }
}