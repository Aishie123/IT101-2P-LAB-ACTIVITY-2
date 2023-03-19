import javax.swing.*;

// Aisha Nicole L. Dones
// Section A122

public class GrossNetPay {

    // CONSTANT VALUES
    private static final double SSS = 175.89, PHILHEALTH = 300.00;

    private static JPanel panel;
    private static JTextField rateField, hoursField, absencesField, lateField;

    public static void main(String[] args){ script(); }

    private static void script(){
        String text, strGross, strNet, strAbsences, strLate, strSSS, strPhilHealth, strTotalDeduction;
        int result, hoursWorked;
        double ratePerHour, totalDeduction, late, absences, gross, net;

        createPanel();

        result = JOptionPane.showConfirmDialog(null, panel, "Gross and Net Pay", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            // check for errors
            try {
                ratePerHour = Double.parseDouble(rateField.getText());
                hoursWorked = Integer.parseInt(hoursField.getText());
                absences = Integer.parseInt(absencesField.getText()) * 5.75;
                late = Integer.parseInt(lateField.getText()) * 3.25;

                gross = getGrossPay(ratePerHour, hoursWorked);
                totalDeduction = getTotalDeduction(absences, late);
                net = getNetPay(gross, totalDeduction);

                strGross = String.format("P%.2f", gross);
                strNet = String.format("P%.2f", net);
                strAbsences = String.format("P%.2f", absences);
                strLate = String.format("P%.2f", late);
                strSSS = String.format("P%.2f", SSS);
                strPhilHealth = String.format("P%.2f", PHILHEALTH);
                strTotalDeduction = String.format("P%.2f", totalDeduction);

                text = "GROSS PAY\t\t: " + strGross + "\n\nAbsences\t\t: " + strAbsences + "\nLate\t\t: " + strLate + "\nSSS\t\t: " + strSSS +
                        "\nPhilHealth\t\t: " + strPhilHealth + "\nTOTAL DEDUCTION\t: " + strTotalDeduction +  "\n\nNET PAY\t\t: " + strNet +
                        "\n\n(Submitted by: Aisha Nicole L. Dones)";

                JOptionPane.showMessageDialog(null, new JTextArea(text), "Gross and Net Pay", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "INVALID INPUT! Please try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
                script(); // run script again
            }

        }
    } // end of script method

    private static void createPanel(){

        panel = new JPanel();

        rateField = new JTextField();
        hoursField = new JTextField();
        absencesField = new JTextField();
        lateField = new JTextField();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Rate per hour:"));
        panel.add(rateField);
        panel.add(Box.createVerticalStrut(5)); // a spacer
        panel.add(new JLabel("Hours of work:"));
        panel.add(hoursField);
        panel.add(Box.createVerticalStrut(5)); // a spacer
        panel.add(new JLabel("No. of days absent:"));
        panel.add(absencesField);
        panel.add(Box.createVerticalStrut(5)); // a spacer
        panel.add(new JLabel("No. of hours late:"));
        panel.add(lateField);

    } // end of createPanel method

    private static double getGrossPay(double ratePerHour, int hoursWorked){ return ratePerHour * hoursWorked; }
    private static double getTotalDeduction(double absences, double late){ return (absences) + (late) + SSS + PHILHEALTH; }
    private static double getNetPay(double gross, double totalDeduction){ return gross - totalDeduction; }

} // end of class
