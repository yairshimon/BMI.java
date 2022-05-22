import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class ControllerBMI extends JPanel {
    private final ImageIcon imageIcon;
    private final ViewBMI s1,s2,s3,s4,s5;

    public ControllerBMI(int x, int y, int width, int height) {
        this.imageIcon = new ImageIcon("2.jpg");
        this.setBounds(x, y, width, height);
        this.setBackground(Color.BLACK);
        BorderLayout borderLayout = new BorderLayout(27, 30);
        this.setLayout(borderLayout);
        s1 = new ViewBMI("2.jpg");
        s2 = new ViewBMI("3.jpg");
        s3 = new ViewBMI("1.jpg");
        s4 = new ViewBMI("4.jpg");
        s5 = new ViewBMI("2.jpg");
        s1.header();
        s2.Gender();
        s2.BodyFrame();
        s3.SlideColorPanel();
        s4.detailsUser();
        s5.buttons();
        add(s1, BorderLayout.NORTH);
        add(s2, BorderLayout.CENTER);
        add(s3, BorderLayout.EAST);
        add(s4, BorderLayout.WEST);
        add(s5, BorderLayout.SOUTH);
        ButtonListener listener = new ButtonListener();
        s5.clear.addActionListener(listener);
        s5.send.addActionListener(listener);
        QuoteListener listenerJCheckBox = new QuoteListener();
        s2.small.addActionListener (listenerJCheckBox);
        s2.medium.addActionListener (listenerJCheckBox);
        s2.large.addActionListener (listenerJCheckBox);
        s2.Male.addActionListener(listenerJCheckBox);
        s2.Female.addActionListener(listenerJCheckBox);
        SliderListener listenerSlideColorPanel = new SliderListener();
        s3.heightSlider.addChangeListener (listenerSlideColorPanel);
        s4.inputActualWeight.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}
            @Override
            public void focusLost(FocusEvent e) {
                String text = s4.inputActualWeight.getText();
                if (!text.isEmpty()) s2.Weight = Float.parseFloat(text);
            }
        });

    }
    private class SliderListener implements ChangeListener {
        public void stateChanged (ChangeEvent event) {
            int weight = s3.heightSlider.getValue();
            s3.weightLabel.setText ("Weight = " + weight);
            s3.highUser1 = weight;
        }
    }

    private class QuoteListener implements ActionListener  {
        public void actionPerformed (ActionEvent event) {
            Object source = event.getSource();
            if(source == s2.Female)
                s2.gender = "Female";
            if(source == s2.Male)
                s2.gender = "Male";
            if (source == s2.small)
                s2.bodyStructure = "small";
            if (source == s2.medium)
                s2.bodyStructure = "medium";
            if (source == s2.large)
                s2.bodyStructure = "large";
        }
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == s5.send){
                double slimness,inputAge;
                if (s2.bodyStructure.equals("small")) slimness = 0.9;
                else if (s2.bodyStructure.equals("medium")) slimness = 1;
                else slimness = 1.1;
                inputAge = Integer.parseInt(s4.inputAge.getText());

                double idealWeight = (s3.sendHeightSlider() - 100 + (inputAge / 10)) * 0.9 * slimness;
                new Answer(s2.Weight / ((s3.sendHeightSlider()) * (s3.sendHeightSlider())), idealWeight, s2.Weight);
                s5.send.setVisible(false);
            }
            s2.groupBodyStructure.clearSelection();
            s2.groupGender.clearSelection();
            s3.clearWeightSlider();
            s4.inputActualWeight.setText("");
            s4.inputFirstName.setText("");
            s4.inputLastName.setText("");
            s4.inputAge.setText("");
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.imageIcon.paintIcon(this, g, ModelBMI.ZERO, ModelBMI.ZERO);
        if(s2.bodyStructure != null && !s4.inputAge.getText().isEmpty() && !s4.inputActualWeight.getText().isEmpty()) {
            s5.send.setVisible(true);
        }
        repaint();
    }
}




