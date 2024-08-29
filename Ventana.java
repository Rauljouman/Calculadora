package MP02Programacion.UF5.Calculadora;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    JPanel panel;
    JTextField caja;

    public Ventana() {
        this.setMinimumSize(new Dimension(385, 465));
        setTitle("Calculadora");
        setLocationRelativeTo(null);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        panel();
        Logica logicaBotones = new Logica(caja);
        Botones botones = new Botones(panel, logicaBotones, caja);
    }

    private void panel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(new Color(0, 0, 0, 230));

        caja = new JTextField();
        caja.setBounds(50, 20, 270, 40); // Ajusta el ancho para que se alinee con los botones
        caja.setHorizontalAlignment(JTextField.RIGHT);
        caja.setEditable(false); // No permitir uso del teclado
        caja.setBackground(Color.white);
        caja.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        Font font = new Font("Arial", Font.ITALIC, 20); // Cambia a cursiva
        caja.setFont(font);
        panel.add(caja);
    }
}
