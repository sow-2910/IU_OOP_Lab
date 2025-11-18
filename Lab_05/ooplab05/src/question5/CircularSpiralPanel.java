package question5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class CircularSpiralPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLUE);

        int w = getWidth();
        int h = getHeight();

        int cx = w / 2;
        int cy = h / 2;

        // Draw a continuous circular (Archimedean-like) spiral by sampling polar coords
        // r = a + b * theta; increase theta and connect successive points
        double a = 0.0;
        double b = Math.max(2, Math.min(w, h) / 40.0); // radial growth per radian
        double maxTheta = 200 * Math.PI; // number of turns (adjust for longer/shorter spiral)
        double delta = 0.06; // radian step, smaller = smoother

        int prevX = cx + (int) Math.round((a + b * 0.0) * Math.cos(0.0));
        int prevY = cy + (int) Math.round((a + b * 0.0) * Math.sin(0.0));

        for (double theta = delta; theta <= maxTheta; theta += delta) {
            double r = a + b * theta;
            int x = cx + (int) Math.round(r * Math.cos(-theta));
            int y = cy + (int) Math.round(r * Math.sin(-theta));
            g2.drawLine(prevX, prevY, x, y);
            prevX = x;
            prevY = y;
        }

        g2.dispose();
    }
}
