package src.app;

import javax.swing.SwingUtilities;
import src.view.VistaPizzeria;
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaPizzeria vista = new VistaPizzeria(); // Crea el objeto y ejecuta su constructor: establece título, tamaño y comportamiento de cierre.
            vista.setVisible(true);
        });
    }
}