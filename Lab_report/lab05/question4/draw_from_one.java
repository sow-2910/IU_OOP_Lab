package question4;

import java.awt.Graphics;
import javax.swing.JPanel;

public class draw_from_one extends JPanel {
    private final int STEPS = 15;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        double stepW = width / (double) STEPS;
        double stepH = height / (double) STEPS;

        for (int k = 0; k < STEPS; k++) {
            int startX = 0;
            int startY = (int) Math.round(k * stepH);
            int endX = (int) Math.round((k + 1) * stepW);
            int endY = height;
            g.drawLine(startX, startY, endX, endY);
        }

    }

}
