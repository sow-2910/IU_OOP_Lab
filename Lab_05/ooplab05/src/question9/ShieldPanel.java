package question9;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class ShieldPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // Center of the panel
        int cx = w / 2;
        int cy = h / 2;

        // Find the maximum radius based on smaller dimension
        int maxRadius = Math.min(w, h) / 2 - 20;

        // Draw concentric circles (outermost to innermost)
        // Red outer circle
        drawFilledCircle(g2, cx, cy, maxRadius, Color.RED);

        // White circle
        drawFilledCircle(g2, cx, cy, (int) (maxRadius * 0.8), Color.WHITE);

        // Red circle
        drawFilledCircle(g2, cx, cy, (int) (maxRadius * 0.6), Color.RED);

        // Dark blue circle
        drawFilledCircle(g2, cx, cy, (int) (maxRadius * 0.4), new Color(0, 0, 139));

        // Draw white star in the center
        drawStar(g2, cx, cy, (int) (maxRadius * 0.25), Color.WHITE);

        g2.dispose();
    }

    /**
     * Draw a filled circle centered at (cx, cy) with given radius and color.
     */
    private void drawFilledCircle(Graphics2D g2, int cx, int cy, int radius, Color color) {
        g2.setColor(color);
        int diameter = radius * 2;
        g2.fillOval(cx - radius, cy - radius, diameter, diameter);
    }

    /**
     * Draw a white 5-pointed star centered at (cx, cy) with given size.
     */
    private void drawStar(Graphics2D g2, int cx, int cy, int size, Color color) {
        g2.setColor(color);

        // Calculate the 5 outer points and 5 inner points of the star
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];

        for (int i = 0; i < 10; i++) {
            double angle = Math.PI / 2 + i * Math.PI / 5; // Start from top, every 36 degrees
            if (i % 2 == 0) {
                // Outer points of the star
                xPoints[i] = (int) (cx + size * Math.cos(angle));
                yPoints[i] = (int) (cy - size * Math.sin(angle));
            } else {
                // Inner points of the star
                int innerSize = (int) (size * 0.4);
                xPoints[i] = (int) (cx + innerSize * Math.cos(angle));
                yPoints[i] = (int) (cy - innerSize * Math.sin(angle));
            }
        }

        Polygon star = new Polygon(xPoints, yPoints, 10);
        g2.fillPolygon(star);
    }
}
