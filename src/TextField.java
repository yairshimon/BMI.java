import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TextField extends JPanel {
    private JLabel header;
    public JCheckBox Male, Female;
    private JLabel firstName, lastName, age;
    private JTextField inputFirstName ,inputLastName,inputAge;
    private final ImageIcon imageIcon;
    private JCheckBox small, medium, large;
    private int weightUser = 0;
    private String bodyStructure ;
    private String gender ;
    ButtonGroup groupGender;
    ButtonGroup groupBodyStructure;
    private JLabel actualWeight;
    private JTextField inputActualWeight;
        public TextField () {
            this.imageIcon = new ImageIcon("1.jpg");
            firstName = new JLabel("Enter first name: ");
            firstName.setBounds(0, 0, 5, 5);
            lastName = new JLabel("Enter last name: ");
            lastName.setBounds(0, 0, 5, 5);

            age = new JLabel("Enter your age: ");
            age.setBounds(0, 0, 5, 5);

            actualWeight = new JLabel ("Enter actual weight: ");
            inputActualWeight = new JTextField (5);
            inputFirstName = new JTextField(5);
            inputLastName = new JTextField(5);
            inputAge = new JTextField(5);
            add(firstName);
            add(inputFirstName);
            add(lastName);
            add(inputLastName);
            add(age);
            add(inputAge);
            setBackground (Color.BLUE);
            setPreferredSize(new Dimension(100, 55));

            inputActualWeight.addActionListener (new TempListener());
            add (actualWeight);
            add (inputActualWeight);
            setPreferredSize (new Dimension(300, 15));
            setBackground (Color.yellow);
            }
            private class TempListener implements ActionListener {

            public void actionPerformed (ActionEvent event) {

            }
        }
}
