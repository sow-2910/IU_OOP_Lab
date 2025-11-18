package question6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class ConcentricCirclesPanel extends JPanel {
    private final int NUM_CIRCLES = 12;
    private final int RADIUS_INCREMENT = 20; // pixels per circle

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);

        int w = getWidth();
        int h = getHeight();

        // center of the panel
        int cx = w / 2;
        int cy = h / 2;

        // draw 12 concentric circles
        for (int i = 1; i <= NUM_CIRCLES; i++) {
            int radius = i * RADIUS_INCREMENT;
            int diameter = radius * 2;

            // upper-left corner of bounding rectangle
            int x = cx - radius;
            int y = cy - radius;

            // draw circle
            g2.drawOval(x, y, diameter, diameter);
        }

        g2.dispose();
    }
}
