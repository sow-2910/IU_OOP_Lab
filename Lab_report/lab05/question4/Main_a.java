package question4;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main_a extends JPanel {
    public static void main(String[] args) {
        draw_from_one panel = new draw_from_one();

        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        application.add(panel);
        application.setSize(500, 500);
        application.setVisible(true);

    }
}
