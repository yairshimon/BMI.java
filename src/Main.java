import javax.swing.*;
public class Main extends JFrame {//נשאר לי לעשות מאזין לכל הטקסט פילד ואז לחבר את זה לclear ואז לחבר את כל הרכיבים לכפתור send ואז להפעיל את סנד עם הפרטים שצריך בתרגיל

    public static final int WINDOW_SIZE = 500;

    public static void main(String[] args) {
        new Main();
    }

    public Main () {
        Board board = new Board(0,0, WINDOW_SIZE, WINDOW_SIZE);
        this.add(board);
        this.setResizable(false);
        this.setSize(WINDOW_SIZE, WINDOW_SIZE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
