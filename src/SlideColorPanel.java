import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class SlideColorPanel extends JPanel {

    private JPanel controls;
    private final ImageIcon imageIcon;

    private JSlider weightSlider;

    public int sendWeightSlider() {
        return weightSlider.getValue();
    }

    public void clearWeightSlider() {
        weightLabel.setText("Weight = 140");
        weightSlider.setValue(140);
    }

    private JLabel weightLabel;
    private int highUser1 = 0;

    public int getHighUser1() {
        return highUser1;
    }

    public SlideColorPanel() {
        this.imageIcon = new ImageIcon("1.jpg");


        weightSlider = new JSlider (JSlider.HORIZONTAL, 140, 200, 140);
        weightSlider.setMajorTickSpacing (10);
        weightSlider.setMinorTickSpacing (1);
        weightSlider.setPaintTicks (true);
        weightSlider.setPaintLabels (true);
        weightSlider.setAlignmentX (Component.LEFT_ALIGNMENT);


        SliderListener listener = new SliderListener();
        weightSlider.addChangeListener (listener);

        weightLabel = new JLabel ("Weight = 140");
        weightLabel.setAlignmentX (Component.LEFT_ALIGNMENT);
        controls = new JPanel();
        BoxLayout layout = new BoxLayout (controls, BoxLayout.Y_AXIS);
        controls.setLayout (layout);
        controls.add (weightLabel);
        controls.add (weightSlider);
        add (controls);
    }


    //  Represents the listener for all three sliders.
    private class SliderListener implements ChangeListener {
        private int Weight;

        // Gets the value of each slider, updates labels and color panel
        public void stateChanged (ChangeEvent event) {
            Weight = weightSlider.getValue();
            weightLabel.setText ("Weight = " + Weight);
            highUser1 = Weight;


            //colorPanel.setBackground (new Color (Weight,0,0));
        }
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0,this.getWidth(), this.getHeight());
        this.imageIcon.paintIcon(this,g,0,0);

    }
}

