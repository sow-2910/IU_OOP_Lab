package question5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class SquareSpiralPanel extends JPanel {
    private final int STEPS = 60; // number of line segments

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.RED);

        int w = getWidth();
        int h = getHeight();

        // center
        int cx = w / 2;
        int cy = h / 2;

        int x = cx;
        int y = cy;

        int step = Math.max(4, Math.min(w, h) / 10); // base increment length
        int len = step;

        for (int i = 0; i < STEPS; i++) {
            int dir = i % 4;
            int nx = x;
            int ny = y;
            switch (dir) {
                case 0: // down
                    ny = y + len;
                    break;
                case 1: // left
                    nx = x - len;
                    break;
                case 2: // up
                    ny = y - len;
                    break;
                case 3: // right
                    nx = x + len;
                    break;
            }
            g2.drawLine(x, y, nx, ny);
            x = nx;
            y = ny;

            if (i % 2 == 1) {
                len += step;
            }
        }

        g2.dispose();
    }
}
