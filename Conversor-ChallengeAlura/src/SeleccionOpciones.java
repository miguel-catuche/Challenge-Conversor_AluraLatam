
import javax.swing.JOptionPane;

public class SeleccionOpciones {
    public void eleccionOpciones() {
        ConversorMonedas metodoMonedas = new ConversorMonedas();
        ConversorTemperatura metodoTemperatura = new ConversorTemperatura();
        Object[] options = {"Convesor de monedas", "Conversor de temperatura"};
        String selectedOption = (String) JOptionPane.showInputDialog(null, "Selecciona una opción", "Menu",
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (selectedOption != null) {//si se selecciona algo entonces funciona
            if (selectedOption.equals(options[0])) {
                metodoMonedas.conversionMoneda();
            } else if (selectedOption.equals(options[1])) {
                metodoTemperatura.conversionTemperatura();
            }
        } else {// Si el usuario cierra el diálogo sin seleccionar ninguna opción
            JOptionPane.showMessageDialog(null, "No seleccionaste ninguna opción");
        }
    }

    public void continuar() {        
            int option = JOptionPane.showOptionDialog(
                null,
                "¿Desea continuar?",
                "Confirmar",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Sí", "No", "Cancelar"},
                "Sí");
        switch (option) {
            case JOptionPane.YES_OPTION:
                eleccionOpciones();
                break;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(null, "Programa finalizado");
                break;
            case JOptionPane.CANCEL_OPTION:
                JOptionPane.showMessageDialog(null, "Programa finalizado");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Programa finalizado");
                break;
        }       
    }   
}
