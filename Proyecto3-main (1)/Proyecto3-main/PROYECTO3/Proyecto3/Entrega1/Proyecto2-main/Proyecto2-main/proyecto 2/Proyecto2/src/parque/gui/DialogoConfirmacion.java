package parque.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

public class DialogoConfirmacion extends JDialog {
    private boolean confirmado = false;

    public DialogoConfirmacion(JFrame parent) {
        super(parent, "Confirmar Reimpresión", true);
        setSize(300, 150);
        setLocationRelativeTo(parent);
        setResizable(false);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel mensaje = new JLabel("<html>Este tiquete ya fue impreso.<br>¿Desea reimprimirlo?</html>", SwingConstants.CENTER);
        panel.add(mensaje, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnSi = new JButton("Sí");
        JButton btnNo = new JButton("No");

        btnSi.addActionListener(e -> {
            confirmado = true;
            dispose();
        });

        btnNo.addActionListener(e -> {
            confirmado = false;
            dispose();
        });

        panelBotones.add(btnSi);
        panelBotones.add(btnNo);
        panel.add(panelBotones, BorderLayout.SOUTH);

        add(panel);
    }

    public boolean isConfirmado() {
        return confirmado;
    }
}