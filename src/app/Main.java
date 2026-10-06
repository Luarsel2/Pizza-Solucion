package src.app;

import src.model.Pizza;
import src.model.Ingredientes;
import src.model.Horno;
import src.model.Cliente;
import src.model.Orden;
import src.model.Cocina;

public class Main {

    public static void main(String[] args) {

        try {
            // jamon, pepperoni, masa, salsa, vegetales, queso, salami
            Ingredientes ingredientes =
                    new Ingredientes(10, 10, 20, 20, 10, 40, 10);

            Horno horno = new Horno(true);
            horno.encender(220);
            horno.definirTiempo(15);

            Cocina cocina = new Cocina(ingredientes, horno);

            Cliente cliente = new Cliente("Joseph", 50000);

            // Crear la receta de la pizza
            Pizza pizza = new Pizza(
                    "Tradicional",
                    "Tomate",
                    "Jamon",
                    8,
                    "Mozzarella"
            );

            // Pedir dos pizzas a Q50.00 cada una
            Orden orden = new Orden(cliente, pizza, 2, 5000);

            // Preparar, cobrar y comer
            cocina.prepararPizza(orden);
            orden.cobrar();
            cliente.comer(orden);

            // Mostrar los resultados
            System.out.println(orden.factura());
            System.out.println();
            System.out.println(cliente);
            System.out.println(ingredientes);

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}