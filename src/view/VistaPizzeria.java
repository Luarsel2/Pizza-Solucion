package src.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VistaPizzeria extends JFrame {

    // ATRIBUTOS
    private JPanel panelPrincipal;
    private JPanel panelFormulario;
    private JPanel panelComprobante;
    private JPanel panelBotones;
    private JPanel panelMasa;

    private JTextField campoNombre;
    private JTextField campoDinero;
    private JTextField campoCantidad;

    private JComboBox<String> selectorSabor;

    private JRadioButton opcionTradicional;
    private JRadioButton opcionDelgada;
    private ButtonGroup grupoMasa;

    private JCheckBox casillaConfirmacion;

    private JButton botonCrear;
    private JButton botonLimpiar;

    private JTextArea areaComprobante;

    // CONSTRUCTOR
    public VistaPizzeria() {
        super("Pizzeria");

        this.panelPrincipal = new JPanel(new BorderLayout(10, 10));
        this.panelFormulario = new JPanel(new GridLayout(6, 2, 10, 10));
        this.panelComprobante = new JPanel(new BorderLayout());
        this.panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.panelMasa = new JPanel(new FlowLayout(FlowLayout.LEFT));

        this.campoNombre = new JTextField();
        this.campoDinero = new JTextField();
        this.campoCantidad = new JTextField("1");

        String[] sabores = {
            "Jamon",
            "Pepperoni",
            "Vegetales",
            "Salami",
            "Sin queso",
            "Salami y jamon",
            "Tres quesos"
        };

        this.selectorSabor = new JComboBox<>(sabores);

        this.opcionTradicional = new JRadioButton("Tradicional", true);
        this.opcionDelgada = new JRadioButton("Delgada");
        this.grupoMasa = new ButtonGroup();

        this.casillaConfirmacion =
                new JCheckBox("He revisado mi pedido");

        this.botonCrear = new JButton("Crear orden");
        this.botonLimpiar = new JButton("Limpiar");

        this.areaComprobante = new JTextArea(10, 35);

        organizarPaneles();

        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // METODOS
    private void organizarPaneles() {
        panelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        panelFormulario.setBorder(
                BorderFactory.createTitledBorder("Datos del pedido")
        );

        panelComprobante.setBorder(
                BorderFactory.createTitledBorder("Comprobante")
        );

        panelBotones.setBorder(
                BorderFactory.createTitledBorder("Acciones")
        );

        // Opciones de masa
        grupoMasa.add(opcionTradicional);
        grupoMasa.add(opcionDelgada);

        panelMasa.add(opcionTradicional);
        panelMasa.add(opcionDelgada);

        // Formulario
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(campoNombre);

        panelFormulario.add(new JLabel("Dinero disponible (Q enteros):"));
        panelFormulario.add(campoDinero);

        panelFormulario.add(new JLabel("Cantidad de pizzas:"));
        panelFormulario.add(campoCantidad);

        panelFormulario.add(new JLabel("Sabor:"));
        panelFormulario.add(selectorSabor);

        panelFormulario.add(new JLabel("Tipo de masa:"));
        panelFormulario.add(panelMasa);

        panelFormulario.add(new JLabel("Precio por pizza: Q50.00"));
        panelFormulario.add(casillaConfirmacion);

        // Area del comprobante
        areaComprobante.setEditable(false);
        areaComprobante.setLineWrap(true);
        areaComprobante.setWrapStyleWord(true);

        JScrollPane desplazamiento =
                new JScrollPane(areaComprobante);

        panelComprobante.add(
                desplazamiento,
                BorderLayout.CENTER
        );

        // Botones
        panelBotones.add(botonCrear);
        panelBotones.add(botonLimpiar);

        // Distribucion principal
        panelPrincipal.add(panelFormulario, BorderLayout.NORTH);
        panelPrincipal.add(panelComprobante, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);
    }

    public String getNombreCliente() {
        return campoNombre.getText().trim();
    }

    public String getDineroIngresado() {
        return campoDinero.getText().trim();
    }

    public String getCantidadIngresada() {
        return campoCantidad.getText().trim();
    }

    public String getSaborSeleccionado() {
        return (String) selectorSabor.getSelectedItem();
    }

    public String getTipoMasaSeleccionada() {
        if (opcionTradicional.isSelected()) {
            return "Tradicional";
        }

        return "Delgada";
    }

    public boolean isPedidoConfirmado() {
        return casillaConfirmacion.isSelected();
    }

    public void agregarAccionCrear(ActionListener accion) {
        botonCrear.addActionListener(accion);
    }

    public void agregarAccionLimpiar(ActionListener accion) {
        botonLimpiar.addActionListener(accion);
    }

    public void mostrarComprobante(String comprobante) {
        areaComprobante.setText(comprobante);
        areaComprobante.setCaretPosition(0);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public void limpiarFormulario() {
        campoNombre.setText("");
        campoDinero.setText("");
        campoCantidad.setText("1");

        selectorSabor.setSelectedIndex(0);
        opcionTradicional.setSelected(true);
        casillaConfirmacion.setSelected(false);

        areaComprobante.setText("");
        campoNombre.requestFocusInWindow();
    }
}