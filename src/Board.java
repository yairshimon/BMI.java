import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel {
    private final ImageIcon imageIcon;
    private UserDetails s2;
    private SlideColorPanel s3;
    private UserDetails s4;
    private JButton clear, send;
    private JLabel label;
    private JPanel buttonPanel;

    public Board(int x, int y, int width, int height) {
        this.imageIcon = new ImageIcon("1.jpg");
        this.setBounds(x, y, width, height);
        this.setBackground(Color.BLACK);
        BorderLayout borderLayout = new BorderLayout(27, 30);
        this.setLayout(borderLayout);
        s2 = new UserDetails();
        s4 = new UserDetails();
        //TextField s4 = new TextField();
        s3 = new SlideColorPanel();
        s2.Gender();
        s2.BodyFrame();
        s4.detailsUser();
        JLabel header1 = new JLabel("BMI test");
        JLabel header2 = new JLabel("Please complete this form. Press the Submit button when complete ");
        JPanel header = new JPanel(true);
        header.add(header1);
        header.add(new JLabel("               "));
        header.add(header2);
        header.setPreferredSize(new Dimension(200, 50));
        add(header, BorderLayout.NORTH);
        add(s2, BorderLayout.CENTER);
        add(s3, BorderLayout.EAST);
        add(s4, BorderLayout.WEST);
        clear = new JButton("Clear");
        send = new JButton("Send");
        ButtonListener listener = new ButtonListener();
        clear.addActionListener(listener);
        send.addActionListener(listener);
        send.setVisible(false);
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(200, 40));
        buttonPanel.setBackground(Color.cyan);
        buttonPanel.add(clear);
        buttonPanel.add(send);
        add(buttonPanel, BorderLayout.SOUTH);

        setPreferredSize(new Dimension(200, 80));
        setBackground(Color.cyan);

        s4.inputActualWeight.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                String text = s4.inputActualWeight.getText();
                if (!text.isEmpty()) s2.Weight = Float.parseFloat(text);
            }
        });

    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == send){
                double slimness = 0,inputAge = 0;
                if (s2.bodyStructure.equals("small")) slimness = 0.9;
                else if (s2.bodyStructure.equals("medium")) slimness = 1;
                else slimness = 1.1;
                inputAge = Integer.parseInt(s4.inputAge.getText());

                double idealWeight = (s3.sendWeightSlider() - 100 + (inputAge / 10)) * 0.9 * slimness;
                new Answer(s2.Weight / ((s3.sendWeightSlider()) * (s3.sendWeightSlider())), idealWeight, s2.Weight);
                send.setVisible(false);
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
        this.imageIcon.paintIcon(this, g, 0, 0);
        if(s2.bodyStructure != null && !s4.inputAge.getText().isEmpty() && !s4.inputActualWeight.getText().isEmpty()) {
            send.setVisible(true);
        }
        repaint();
    }
}




