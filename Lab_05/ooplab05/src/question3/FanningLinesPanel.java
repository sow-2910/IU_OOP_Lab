package question3;

import java.awt.Graphics;
import javax.swing.JPanel;

public class FanningLinesPanel extends JPanel {
    private final int STEPS = 50;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        // Use floating point step sizes so lines reach the edges evenly
        double stepW = width / (double) STEPS;
        double stepH = height / (double) STEPS;

        // Draw fanning lines from each corner to points along the opposite edges.
        // This produces the nested rotated-square / fanning-lines pattern.
        for (int i = 0; i <= STEPS; i++) {
            int x = (int) Math.round(i * stepW);
            int y = (int) Math.round(i * stepH);

            // from top-left corner to points on top->right->bottom sweep
            // target moves from (width,0) down to (width - width, height)
            g.drawLine(0, 0, width - x, y);

            // from top-right corner
            g.drawLine(width, 0, x, y);

            // from bottom-right corner
            g.drawLine(width, height, x, height - y);

            // from bottom-left corner
            g.drawLine(0, height, width - x, height - y);
        }

    }

}
