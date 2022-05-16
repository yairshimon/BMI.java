import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserDetails extends JPanel {
    private JLabel header;
    public JCheckBox Male, Female;
    private final ImageIcon imageIcon;
    private JCheckBox small, medium, large;
    public String bodyStructure ;
    public String gender ;
    ButtonGroup groupGender;
    ButtonGroup groupBodyStructure;
    public String Weight;



    public UserDetails() {
        this.imageIcon = new ImageIcon("1.jpg");
    }

    private JTextField inputActualWeight;

    public void BodyFrame()  {
        header = new JLabel ("     body-frame:    ");
        header.setFont (new Font("Helvetica", Font.BOLD, 20));
        small = new JCheckBox ("Small");
        small.setBackground (Color.cyan);
        medium = new JCheckBox ("Medium");
        medium.setBackground (Color.cyan);
        large = new JCheckBox ("Large");
        large.setBackground (Color.cyan);
        groupBodyStructure = new ButtonGroup();
        groupBodyStructure.add (small);
        groupBodyStructure.add (medium);
        groupBodyStructure.add (large);
        QuoteListener listener = new QuoteListener();
        small.addActionListener (listener);
        medium.addActionListener (listener);
        large.addActionListener (listener);
        add (header);
        add (small);
        add (medium);
        add (large);
        setBackground (Color.green);
        setPreferredSize (new Dimension(300, 100));
    }

    private class QuoteListener implements ActionListener  {

        public void actionPerformed (ActionEvent event) {

            Object source = event.getSource();
            if(source == Female)
                gender = "Female";
            if(source == Male)
                gender = "Male";
            if (source == small)
                bodyStructure = "small";
            if (source == medium)
                bodyStructure = "medium";
            if (source == large)
                bodyStructure = "large";
        }
    }
    public void detailsUser() {
        JLabel firstName = new JLabel("Enter first name:");
        firstName.setBounds(2220, 200, 12, 12);
        JLabel lastName = new JLabel("Enter last name:");
        JLabel age = new JLabel("Enter your age:");
        JLabel actualWeight = new JLabel("Enter weight:");
        JTextField inputFirstName = new JTextField(5);
        JTextField inputLastName = new JTextField(5);
        JTextField inputAge = new JTextField(5);
        inputActualWeight = new JTextField (5);
        add(firstName);
        add(inputFirstName);
        add(lastName);
        add(inputLastName);
        add(age);
        add(inputAge);
        add(actualWeight);
        add(inputActualWeight);
        TempListener tempListener = new TempListener();
        inputFirstName.addActionListener (tempListener);
        inputLastName.addActionListener (tempListener);
        inputAge.addActionListener (tempListener);
        inputActualWeight.addActionListener (tempListener);
        setBackground (Color.BLUE);
        setPreferredSize(new Dimension(100, 55));
        }

     private class TempListener implements ActionListener {

        public void actionPerformed (ActionEvent event) {
            if(inputActualWeight.getText().length() != 0){
                Weight = inputActualWeight.getText();
                System.out.println(";;;");
            }


        }
}

    public void Gender() {
        header = new JLabel("gender:");
        header.setFont(new Font("Helvetica", Font.BOLD, 20));
        Male = new JCheckBox("Male");
        Male.setBackground(Color.WHITE);
        Female = new JCheckBox("Female");
        Female.setBackground(Color.WHITE);
        add(header);
        groupGender = new ButtonGroup();
        groupGender.add(Male);
        groupGender.add(Female);
        QuoteListener listener = new QuoteListener();
        Male.addActionListener(listener);
        Female.addActionListener(listener);
        add(Male);
        add(Female);
        setBackground(Color.green);
        setPreferredSize(new Dimension(300, 100));

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0,this.getWidth(), this.getHeight());
        this.imageIcon.paintIcon(this,g,0,0);
        }
}
