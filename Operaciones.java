package MP02Programacion.UF5.Calculadora;

public class Operaciones {

    public Operaciones() {}

    public double realizarOperacion(double a, double b, String operador) throws ArithmeticException {
        switch (operador) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
            default:
                throw new ArithmeticException("Invalid operator");
        }
    }

    public void limpiar() {
        // Método para limpiar cualquier estado interno si es necesario
    }
}
