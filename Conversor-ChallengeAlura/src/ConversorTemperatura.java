
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ConversorTemperatura {

    SeleccionOpciones elegirOpcion = new SeleccionOpciones();
    temperatura valorTemperatura = new temperatura();
    DecimalFormat formato = new DecimalFormat("#.00");

    public void mensajeFinal(String medidaElegida, String medidaToConvertir, double valorRecibido, double valorConvertido) {
        String resultadoConvertido = formato.format(valorConvertido);
        String mensajeFinal = "La cantidad de " + valorRecibido + " grados " + medidaElegida + " es igual a " + resultadoConvertido + " grados " + medidaToConvertir;
        JOptionPane.showMessageDialog(null, mensajeFinal);
        elegirOpcion.continuar();
    }

    public void conversion(String medidaElegida, String medidaToConvertir, String conversionElegida, double valorGeneral) {
        valorTemperatura.setMedida(medidaElegida, valorGeneral);//medida inicial para convertir
        double totalConvertido = 0.0;
        switch (conversionElegida) {
            case "celsiusTokelvin":
                totalConvertido = valorTemperatura.getCelsius() + 273.15;
                break;
            case "celsiusTofahrenheit":
                totalConvertido = (valorTemperatura.getCelsius() * 1.8) + 32;
                break;
            case "kelvinTocelsius":
                totalConvertido = valorTemperatura.getKelvin() - 273.15;
                break;
            case "kelvinTofahrenheit":
                totalConvertido = 1.8 * (valorTemperatura.getKelvin() - 273.15) + 32;
                break;
            case "fahrenheitTocelsius":
                totalConvertido = (valorTemperatura.getFahrenheit() - 32) / 1.8;
                break;
            case "fahrenheitTokelvin":
                totalConvertido = (valorTemperatura.getFahrenheit() - 32) * 5 / 9 + 273.15;
                break;
            default:
                break;
        }
        valorTemperatura.setMedida(medidaToConvertir, totalConvertido);//medida de temperatura convertida        
        mensajeFinal(medidaElegida, medidaToConvertir, valorTemperatura.getValorGeneral(), totalConvertido);        
    }

    public void eleccionMedidaTemperatura() {
        Object[] options = {"De Celsius a Kelvin", "De Celsius a Fahrenheit",
            "De Kelvin a Celsius", "De Kelvin a Fahrenheit", "De Fahrenheit a Celsius",
            "De Fahrenheit a Kelvin"};

        String selectedOption = (String) JOptionPane.showInputDialog(null, "Elije la medida a convertir", "Temperatura",
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (selectedOption != null) {//si se selecciona algo entonces funciona
            switch (selectedOption) {
                case "De Celsius a Kelvin":
                    conversion("Celsius", "Kelvin", "celsiusTokelvin", valorTemperatura.getValorGeneral());
                    break;
                case "De Celsius a Fahrenheit":
                    conversion("Celsius", "Fahrenheit", "celsiusTofahrenheit", valorTemperatura.getValorGeneral());
                    break;
                case "De Kelvin a Celsius":
                    conversion("Kelvin", "Celsius", "kelvinTocelsius", valorTemperatura.getValorGeneral());
                    break;
                case "De Kelvin a Fahrenheit":
                    conversion("Kelvin", "Fahrenheit", "kelvinTofahrenheit", valorTemperatura.getValorGeneral());
                    break;
                case "De Fahrenheit a Celsius":
                    conversion("Fahrenheit", "Celsius", "fahrenheitTocelsius", valorTemperatura.getValorGeneral());
                    break;
                case "De Fahrenheit a Kelvin":
                    conversion("Fahrenheit", "Kelvin", "fahrenheitTokelvin", valorTemperatura.getValorGeneral());
                    break;
            }
        } else {// Si el usuario cierra el diálogo sin seleccionar ninguna opción
            JOptionPane.showMessageDialog(null, "No seleccionaste ninguna opción");
        }
    }

    public void conversionTemperatura() {

        JTextField textField = new JTextField();
        Object[] message = {
            "Digite la cantidad a convertir:", textField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Conversión de temperatura", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String valorRecibido = textField.getText();
            if (!valorRecibido.trim().isEmpty()) {
                try {
                    double valorDigitado = Double.parseDouble(valorRecibido);
                    if (valorDigitado > 0 || valorDigitado < 0) {
                        valorTemperatura.setValorGeneral(valorDigitado);
                        eleccionMedidaTemperatura();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: cantidad ingresada no válida", "Error de entrada",
                                JOptionPane.ERROR_MESSAGE);
                        conversionTemperatura();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: valor ingresado no válido", "Error de entrada",
                            JOptionPane.ERROR_MESSAGE);
                    conversionTemperatura();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error: No ingresaste ningún valor", "Error de entrada",
                        JOptionPane.ERROR_MESSAGE);
                conversionTemperatura();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Saliste del programa", "Programa finalizado",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
}
