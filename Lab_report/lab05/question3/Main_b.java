package question3;

import javax.swing.*;

public class Main_b {
    public static void main(String[] args) {
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FanningLinesPanel panel = new FanningLinesPanel();
        application.add(panel);

        application.setSize(250, 250);
        application.setVisible(true);
    }
}
