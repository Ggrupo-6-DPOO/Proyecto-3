package parque.gui;

import javax.swing.*;
import java.awt.*;

import parque.gestores.GestorTiquetes;
import parque.ventas.Tiquete;

public class VentanaPrincipal extends JFrame {
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private PanelCompraTiquete panelCompra;
    private PanelMostrarTiquete panelMostrar;

    private GestorTiquetes gestorTiquetes;
    private Tiquete tiqueteActual;

    public VentanaPrincipal() {
        setTitle("Sistema de Tiquetes - Parque de Atracciones");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear gestor
        gestorTiquetes = new GestorTiquetes();
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        // Crear los paneles con el gestor
        panelCompra = new PanelCompraTiquete(this, gestorTiquetes);
        panelMostrar = new PanelMostrarTiquete(this, gestorTiquetes);

        // Agregar paneles al cardLayout
        panelPrincipal.add(panelCompra, "compra");
        panelPrincipal.add(panelMostrar, "mostrar");

        add(panelPrincipal);

        // Mostrar el panel de compra inicialmente
        mostrarPanelCompra();
    }

    public void mostrarPanelCompra() {
        cardLayout.show(panelPrincipal, "compra");
    }

    public void mostrarPanelMostrar(Tiquete tiquete) {
        panelMostrar.mostrarTiquete(tiquete);
        cardLayout.show(panelPrincipal, "mostrar");
    }

    public void setTiqueteActual(Tiquete t) {
        this.tiqueteActual = t;
        panelMostrar.mostrarTiquete(t);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}
