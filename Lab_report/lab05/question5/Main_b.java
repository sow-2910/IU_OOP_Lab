package question5;

import javax.swing.JFrame;

public class Main_b {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Circular Spiral");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CircularSpiralPanel());
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
