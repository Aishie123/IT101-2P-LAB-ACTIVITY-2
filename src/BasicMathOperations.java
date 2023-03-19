import javax.swing.*;
import java.math.BigDecimal;

// Aisha Nicole L. Dones
// Section A122

public class BasicMathOperations {

    private static JPanel panel;
    private static JTextField n1Field, n2Field;

    public static void main(String[] args){
        script();
    } // end of main

    public static void script(){
        String text, strSum, strDiff, strPrd, strQt;
        double n1, n2;
        int result;

        createPanel();

        result = JOptionPane.showConfirmDialog(null, panel,
                "Basic Math Operations", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            // check for errors
            try {
                n1 = Double.parseDouble(n1Field.getText());
                n2 = Double.parseDouble(n2Field.getText());

                // operation -> BigDecimal -> remove trailing zeros -> remove scientific notation
                strSum = BigDecimal.valueOf(add(n1, n2)).stripTrailingZeros().toPlainString();
                strDiff = BigDecimal.valueOf(subtract(n1, n2)).stripTrailingZeros().toPlainString();
                strPrd = BigDecimal.valueOf(multiply(n1, n2)).stripTrailingZeros().toPlainString();
                strQt = BigDecimal.valueOf(divide(n1, n2)).stripTrailingZeros().toPlainString();

                text = "SUM\t: " + strSum + "\nDIFFERENCE\t: " + strDiff
                        + "\nPRODUCT\t: " + strPrd + "\nQUOTIENT\t: " + strQt +
                        "\n\nSubmitted by\t: Aisha Nicole L. Dones";
                JOptionPane.showMessageDialog(null, new JTextArea(text),
                        "Basic Math Operations", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "INVALID INPUT! Please try again.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                script(); // run script again
            }
        } // end of "result" conditional statement
    } // end of script method

    private static void createPanel(){

        panel = new JPanel();

        n1Field = new JTextField(4);
        n2Field = new JTextField(4);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Enter the first number:"));
        panel.add(n1Field);
        panel.add(Box.createVerticalStrut(5)); // a spacer
        panel.add(new JLabel("Enter the second number:"));
        panel.add(n2Field);

    } // end of showPanel method

    // MATH OPERATIONS
    private static double add (double n1, double n2){ return n1 + n2; }
    private static double subtract (double n1, double n2){ return n1 - n2; }
    private static double multiply (double n1, double n2){ return n1 * n2; }
    private static double divide (double n1, double n2){ return n1 / n2; }

}
