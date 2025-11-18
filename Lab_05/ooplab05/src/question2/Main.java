package question2;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawPanel panel = new DrawPanel();

        application.add(panel);

        application.setSize(1000, 300);

        application.setVisible(true);
    }
}
