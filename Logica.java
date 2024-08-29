package MP02Programacion.UF5.Calculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logica implements ActionListener {
    private JTextField caja;
    private Operaciones operacions;
    private boolean puntDecimal;
    private double primerNum;
    private String operador;
    private boolean nouNum;

    public Logica(JTextField caja) {
        this.caja = caja;
        this.operacions = new Operaciones();
        this.puntDecimal = false;
        this.primerNum = 0;
        this.operador = "";
        this.nouNum = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "OFF":
                System.exit(0);
                break;
            case "C":
                caja.setText("");
                operacions.limpiar();
                puntDecimal = false;
                operador = "";
                primerNum = 0;
                nouNum = true;
                break;
            case "CE":
                String textoActual = caja.getText();
                if (!textoActual.isEmpty()) {
                    caja.setText(textoActual.substring(0, textoActual.length() - 1));
                }
                if (!caja.getText().contains(".")) {
                    puntDecimal = false;
                }
                break;
            case "=":
                try {
                    double segunNum = Double.parseDouble(caja.getText());
                    double resultado = operacions.realizarOperacion(primerNum, segunNum, operador);
                    caja.setText(String.valueOf(resultado));
                    puntDecimal = String.valueOf(resultado).contains(".");
                    nouNum = true;
                } catch (ArithmeticException | NumberFormatException ex) {
                    caja.setText("Error");
                    nouNum = true;
                }
                operacions.limpiar();
                operador = "";
                break;
            case ".":
                if (!puntDecimal) {
                    caja.setText(caja.getText() + ".");
                    puntDecimal = true;
                    nouNum = false;
                }
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                try {
                    primerNum = Double.parseDouble(caja.getText());
                    operador = comando;
                    caja.setText("");
                    puntDecimal = false;
                    nouNum = true;
                } catch (NumberFormatException ex) {
                    caja.setText("Error");
                    nouNum = true;
                }
                break;
            default:
                if (nouNum) {
                    caja.setText(comando);
                    nouNum = false;
                } else {
                    caja.setText(caja.getText() + comando);
                }
                break;
        }
    }
}