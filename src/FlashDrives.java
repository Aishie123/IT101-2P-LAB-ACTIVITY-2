import javax.swing.*;

// Aisha Nicole L. Dones
// Section A122

public class FlashDrives {

    private static JPanel panel;
    private static JTextField nameField, fdField;
    private static int grossFD, dozenFD, extraFD;

    public static void main(String[] args){
        script();
    } // end of main

    private static void script(){
        String name, text;
        int result, fd;

        createPanel();

        result = JOptionPane.showConfirmDialog(null, panel, "Phone Details", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            // check for errors
            try {

                name = nameField.getText();
                fd = Integer.parseInt(fdField.getText());
                computeFD(fd);

                text = "Hi Mr./Ms. " + name + ", you have " + grossFD + " gross, " + dozenFD + " dozen, and " + extraFD + " extra flash drives." +
                        "\n(Submitted by\t: Aisha Nicole L. Dones)";
                JOptionPane.showMessageDialog(null, text, "Phone Details", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "INVALID INPUT! Please try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
                script(); // run script again
            }
        }
    } // end of script method

    private static void createPanel(){

        panel = new JPanel();

        nameField = new JTextField(4);
        fdField = new JTextField(4);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(Box.createVerticalStrut(5)); // a spacer
        panel.add(new JLabel("Number of Flash Drives:"));
        panel.add(fdField);

    } // end of createPanel method

    private static void computeFD(int fd){
        grossFD = fd / 144;
        dozenFD = (fd % 144) / 12;
        extraFD = (fd % 144) % 12;
    }

} // end of class
