package question4;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main_b extends JPanel {
    public static void main(String[] args) {
        draw_from_coners panel = new draw_from_coners();

        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        application.add(panel);

        application.setSize(250, 250);

        application.setVisible(true);

    }
}
