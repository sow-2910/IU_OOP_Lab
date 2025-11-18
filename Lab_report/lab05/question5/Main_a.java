package question5;

import javax.swing.JFrame;

public class Main_a {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Square Spiral");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SquareSpiralPanel());
        frame.setSize(250, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
