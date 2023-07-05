
import javax.swing.JOptionPane;

public class temperatura {

    private double celsius;
    private double fahrenheit;
    private double kelvin;
    private double valorGeneral;

    public void setMedida(String nombreMedida, double valorObtenido) {
        if (valorObtenido > 0 || valorObtenido < 0) {
            switch (nombreMedida) {
                case "Celsius":
                    setCelsius(valorObtenido);
                    break;
                case "Kelvin":
                    setKelvin(valorObtenido);
                    break;
                case "Fahrenheit":
                    setFahrenheit(valorObtenido);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Valor no válido");
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Valor no válido");
        }
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public double getKelvin() {
        return kelvin;
    }

    public void setKelvin(double kelvin) {
        this.kelvin = kelvin;
    }

    public double getValorGeneral() {
        return valorGeneral;
    }

    public void setValorGeneral(double valorGeneral) {
        this.valorGeneral = valorGeneral;
    }
}
