import javax.swing.*;
import java.awt.*;

public class ViewBMI extends JPanel {
    public float Weight;
    private JLabel header;
    public JCheckBox Male, Female;
    private final ImageIcon imageIcon;
    public JCheckBox small, medium, large;
    public String bodyStructure ;
    public String gender ;
    ButtonGroup groupGender;
    ButtonGroup groupBodyStructure;

    public JTextField inputFirstName,inputLastName,inputAge,inputActualWeight;


    public JSlider heightSlider;
    public JLabel weightLabel;
    public int highUser1 ;
    public JButton clear, send;

    public ViewBMI(String image) {
        this.imageIcon = new ImageIcon(image);
        Weight = 0;
        highUser1 = 0;
    }

    public float sendHeightSlider() {
        return heightSlider.getValue();
    }

    public void clearWeightSlider() {
        weightLabel.setText("Weight = 140");
        heightSlider.setValue(ModelBMI.MIN_SLIDE_COLOR_PANEL);
    }


    public void header(){
        JLabel header1 = new JLabel("BMI TEST");
        JLabel header2 = new JLabel("Please complete this form. Press the Send button when complete ");
        JLabel header3 = new JLabel("The Send button will appear after you fill in the details ");
        JPanel header = new JPanel(true);
        header.add(header1);
        header.add(new JLabel("               "));
        header.add(header2);
        header.add(header3);
        header.setBackground(Color.CYAN);
        header.setPreferredSize(new Dimension(400, 70));
        add(header);
    }

    public void SlideColorPanel() {
        heightSlider = new JSlider (JSlider.HORIZONTAL, ModelBMI.MIN_SLIDE_COLOR_PANEL, ModelBMI.MAX_SLIDE_COLOR_PANEL, ModelBMI.MIN_SLIDE_COLOR_PANEL);
        heightSlider.setMajorTickSpacing (ModelBMI.MAJOR_TICK_SPACING);
        heightSlider.setMinorTickSpacing (ModelBMI.MINOR_TICK_SPACING);
        heightSlider.setPaintTicks (true);
        heightSlider.setPaintLabels (true);
        heightSlider.setAlignmentX (Component.LEFT_ALIGNMENT);
        weightLabel = new JLabel ("Weight = 140");
        weightLabel.setAlignmentX (Component.LEFT_ALIGNMENT);
        JPanel controls = new JPanel();
        BoxLayout layout = new BoxLayout (controls, BoxLayout.Y_AXIS);
        controls.setLayout (layout);
        controls.add (weightLabel);
        controls.add (heightSlider);
        add (controls);
    }

    public void BodyFrame()  {
        header = new JLabel ("     body-frame:    ");
        header.setFont (new Font("Helvetica", Font.BOLD, ModelBMI.SIZE_FONT));
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
        add (header);
        add (small);
        add (medium);
        add (large);
        setBackground (Color.green);
        setPreferredSize (new Dimension(ModelBMI.WIDTH_CENTER_PANEL, ModelBMI.HEIGHT_CENTER_PANEL));
    }

    public void detailsUser() {
        JLabel firstName = new JLabel("Enter first name:");
        JLabel lastName = new JLabel("Enter last name:");
        JLabel age = new JLabel("Enter your age:");
        JLabel actualWeight = new JLabel("Enter weight:");
        inputFirstName = new JTextField(ModelBMI.SIZE_TEXT_FIELD);
        inputLastName = new JTextField(ModelBMI.SIZE_TEXT_FIELD);
        inputAge = new JTextField(ModelBMI.SIZE_TEXT_FIELD);
        inputActualWeight = new JTextField (ModelBMI.SIZE_TEXT_FIELD);
        add(firstName);
        add(inputFirstName);
        add(lastName);
        add(inputLastName);
        add(age);
        add(inputAge);
        add(actualWeight);
        add(inputActualWeight);
        setBackground (Color.BLUE);
        setPreferredSize(new Dimension(100, 55));
        }


    public void Gender() {
        header = new JLabel("gender:");
        header.setFont(new Font("Helvetica", Font.BOLD, ModelBMI.SIZE_FONT));
        Male = new JCheckBox("Male");
        Male.setBackground(Color.CYAN);
        Female = new JCheckBox("Female");
        Female.setBackground(Color.CYAN);
        add(header);
        groupGender = new ButtonGroup();
        groupGender.add(Male);
        groupGender.add(Female);
        add(Male);
        add(Female);
        setBackground(Color.green);
        setPreferredSize(new Dimension(ModelBMI.WIDTH_CENTER_PANEL, ModelBMI.HEIGHT_CENTER_PANEL));
    }
    public void buttons(){
        clear = new JButton("Clear");
        send = new JButton("Send");
        send.setVisible(false);
        add(clear);
        add(send);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(ModelBMI.ZERO, ModelBMI.ZERO,this.getWidth(), this.getHeight());
        this.imageIcon.paintIcon(this,g,ModelBMI.ZERO,ModelBMI.ZERO);
        }
}
