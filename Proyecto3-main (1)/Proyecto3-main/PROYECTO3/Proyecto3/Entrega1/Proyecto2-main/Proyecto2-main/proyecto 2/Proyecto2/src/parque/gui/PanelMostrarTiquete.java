package parque.gui;

import javax.swing.*;
import java.awt.*;

import parque.gestores.GestorTiquetes;
import parque.ventas.Tiquete;

public class PanelMostrarTiquete extends JPanel {
    private VentanaPrincipal ventana;
    private GestorTiquetes gestorTiquetes;

    private JButton btnVolver;
    private JButton btnImprimir;
    private JLabel lblTipo;
    private JLabel lblId;
    private JLabel lblFecha;
    private JLabel lblQR;

    private Tiquete tiquete;

    public PanelMostrarTiquete(VentanaPrincipal ventana, GestorTiquetes gestorTiquetes) {
        this.ventana = ventana;
        this.gestorTiquetes = gestorTiquetes;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));

        JPanel panelInfo = new JPanel(new GridLayout(4, 1, 10, 10));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTitulo = new JLabel("Tiquete Generado", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        panelInfo.add(lblTitulo);

        lblTipo = new JLabel("Tipo: ");
        lblId = new JLabel("ID: ");
        lblFecha = new JLabel("Fecha: ");

        panelInfo.add(lblTipo);
        panelInfo.add(lblId);
        panelInfo.add(lblFecha);

        add(panelInfo, BorderLayout.NORTH);

        JPanel panelQR = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblQR = new JLabel("Código QR aparecerá aquí");
        lblQR.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        lblQR.setPreferredSize(new Dimension(200, 200));
        panelQR.add(lblQR);
        add(panelQR, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> ventana.mostrarPanelCompra());

        btnImprimir = new JButton("Imprimir");
        btnImprimir.addActionListener(e -> imprimirTiquete());

        panelBotones.add(btnVolver);
        panelBotones.add(btnImprimir);
        add(panelBotones, BorderLayout.SOUTH);
    }

    public void mostrarTiquete(Tiquete t) {
        this.tiquete = t;

        lblTipo.setText("Tipo: " + t.getTipo().name());
        lblId.setText("ID: " + t.getId());
        lblFecha.setText("Fecha: " + t.getFechaCompra());

        lblQR.setText("QR: " + t.getId()); // Placeholder para el QR real
    }

    private void imprimirTiquete() {
        if (gestorTiquetes.estaImpreso(tiquete.getId())) {
            DialogoConfirmacion dialogo = new DialogoConfirmacion(ventana);
            dialogo.setVisible(true);
            if (!dialogo.isConfirmado()) {
                return;
            }
        }

        gestorTiquetes.marcarComoImpreso(tiquete.getId());

        JOptionPane.showMessageDialog(this,
            "Tiquete impreso correctamente",
            "Impresión Exitosa",
            JOptionPane.INFORMATION_MESSAGE);
    }
}
