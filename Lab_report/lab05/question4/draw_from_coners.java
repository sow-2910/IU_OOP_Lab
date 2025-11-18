package question4;

import java.awt.Graphics;
import javax.swing.JPanel;

public class draw_from_coners extends JPanel {
    private final int STEPS = 15;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        double stepW = width / (double) STEPS;
        double stepH = height / (double) STEPS;

        for (int i = 0; i < STEPS; i++) {

            // Left edge -> bottom edge (top-left fan)
            int startLX = 0;
            int startLY = (int) Math.round(i * stepH);
            int endBX = (int) Math.round((i + 1) * stepW);
            int endBY = height;
            g.drawLine(startLX, startLY, endBX, endBY);

            // Right edge -> bottom edge (top-right fan)
            int startRX = width;
            int startRY = (int) Math.round(i * stepH);
            int endBX2 = (int) Math.round(width - (i + 1) * stepW);
            int endBY2 = height;
            g.drawLine(startRX, startRY, endBX2, endBY2);

            // Right edge -> top edge (bottom-right fan)
            int startRX2 = width;
            int startRY2 = (int) Math.round(height - i * stepH);
            int endTX2 = (int) Math.round(width - (i + 1) * stepW);
            int endTY2 = 0;
            g.drawLine(startRX2, startRY2, endTX2, endTY2);

            // Left edge -> top edge (bottom-left fan)
            int startLX2 = 0;
            int startLY2 = (int) Math.round(height - i * stepH);
            int endTX = (int) Math.round((i + 1) * stepW);
            int endTY = 0;
            g.drawLine(startLX2, startLY2, endTX, endTY);
        }
    }
}
