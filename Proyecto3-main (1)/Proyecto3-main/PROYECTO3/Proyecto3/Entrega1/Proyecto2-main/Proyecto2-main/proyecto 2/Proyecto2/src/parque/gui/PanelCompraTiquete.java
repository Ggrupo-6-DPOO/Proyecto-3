package parque.gui;

import javax.swing.*;
import java.awt.*;

import parque.gestores.GestorTiquetes;
import parque.ventas.Tiquete;
import parque.ventas.TipoTiquete;

public class PanelCompraTiquete extends JPanel {
    private VentanaPrincipal ventana;
    private GestorTiquetes gestorTiquetes;
    private JComboBox<TipoTiquete> comboBoxTipo;
    private JButton btnGenerar;

    public PanelCompraTiquete(VentanaPrincipal ventana, GestorTiquetes gestorTiquetes) {
        this.ventana = ventana;
        this.gestorTiquetes = gestorTiquetes;
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel lblTitulo = new JLabel("Seleccione el tipo de tiquete");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        add(new JLabel("Tipo de tiquete:"), gbc);

        gbc.gridx = 1;
        comboBoxTipo = new JComboBox<>(TipoTiquete.values());
        add(comboBoxTipo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        btnGenerar = new JButton("Generar Tiquete");
        btnGenerar.addActionListener(e -> generarTiquete());
        add(btnGenerar, gbc);
    }

    private void generarTiquete() {
        TipoTiquete tipoSeleccionado = (TipoTiquete) comboBoxTipo.getSelectedItem();

        // Parámetros de ejemplo, podrías permitir personalizarlos después
        double precio = 50000;
        int cupoMaximo = 1;
        boolean esDeTemporada = false;
        double descuento = 0.0;
        boolean fastPass = false;

        Tiquete tiquete = gestorTiquetes.generarTiquete(precio, cupoMaximo, esDeTemporada, tipoSeleccionado, descuento, fastPass);

        ventana.mostrarPanelMostrar(tiquete);
    }
}
