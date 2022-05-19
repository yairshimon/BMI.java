import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Board extends JPanel {
    private final ImageIcon imageIcon;
    private UserDetails s2 ;
    private SlideColorPanel s3;
    private UserDetails s4;
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
        JLabel header1 = new JLabel ("BMI test");
        JLabel header2 = new JLabel ("Please complete this form. Press the Submit button when complete ");
        JPanel header = new JPanel(true);
        header.add(header1);
        header.add(new JLabel("               "));
        header.add(header2);
        header.setPreferredSize (new Dimension(200, 50));
        add (header,BorderLayout.NORTH);
        add (s2, BorderLayout.CENTER);
        add (s3, BorderLayout.EAST);
        add (s4, BorderLayout.WEST);

       // repaint();
        JButton jButton1 = new JButton("clear");
        JButton jButton2 = new JButton("send");
        ButtonListener listener = new ButtonListener();
        jButton1.addActionListener(listener);
        jButton2.addActionListener(listener);
        JPanel bot = new JPanel(true);
        bot.add(jButton1);
        bot.add(jButton2);
        add (bot, BorderLayout.SOUTH);
        ButtonGroup groupBodyStructure = new ButtonGroup();
        groupBodyStructure.add (jButton1);
        groupBodyStructure.add (jButton2);
        s4.inputActualWeight.addFocusListener(new FocusListener() {
            @Override public void focusGained(FocusEvent e) {}
            @Override
            public void focusLost(FocusEvent e) {
                String text = s4.inputActualWeight.getText();
                if(!text.isEmpty()) s2.Weight = Float.parseFloat (text);
            }
        });

    }

    private class ButtonListener implements ActionListener {
         public void actionPerformed(ActionEvent event) {
             new Answer(s2.Weight/(s3.sendWeightSlider()*s3.sendWeightSlider()));
             s2.groupBodyStructure.clearSelection();
             s2.groupGender.clearSelection();
             s3.clearWeightSlider();
             s4.inputActualWeight.setText("");
             s4.inputFirstName.setText("");
             s4.inputLastName.setText("");
             s4.inputAge.setText("");
             System.out.println(s2.Weight/(s3.sendWeightSlider()*s3.sendWeightSlider()));
         }
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.imageIcon.paintIcon(this, g, 0, 0);

        }
    }

