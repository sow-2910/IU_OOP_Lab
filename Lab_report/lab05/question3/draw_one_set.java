package question3;

import java.awt.*;
import javax.swing.*;

public class draw_one_set extends JPanel {
    private final int STEPS = 25;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int xdelta = width / STEPS;
        int ydelta = height / STEPS;

        for (int i = 0; i < STEPS; i++) {
            int x = width - (i - 1) * xdelta;
            int y = (i - 1) * ydelta;
            g.drawLine(0, 0, x, y);
        }
    }
}
