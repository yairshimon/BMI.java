import javax.swing.*;
public class Main extends JFrame {

    public static void main(String[] args) {
        new Main();
    }

    public Main () {
        ControllerBMI board = new ControllerBMI(ModelBMI.ZERO,ModelBMI.ZERO, ModelBMI.WINDOWS_WIDTH_MAIN_FRAME, ModelBMI.WINDOWS_HEIGHT_MAIN_FRAME);
        this.add(board);
        this.setResizable(false);
        this.setSize(ModelBMI.WINDOWS_WIDTH_MAIN_FRAME, ModelBMI.WINDOWS_HEIGHT_MAIN_FRAME);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
