package question7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;
import javax.swing.JPanel;

public class RandomShapesPanel extends JPanel {
    private final int NUM_SHAPES = 10;
    private Random random;

    public RandomShapesPanel() {
        // Use a fixed seed to get reproducible results
        random = new Random(42);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // Reset random with seed for consistent output each paint
        random = new Random(42);

        // Draw 10 random shapes
        for (int i = 0; i < NUM_SHAPES; i++) {
            // Random color
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g2.setColor(color);

            // Random dimensions (limited to half width or height)
            int width = random.nextInt(w / 2) + 1;
            int height = random.nextInt(h / 2) + 1;

            // Random position (ensure shape stays within bounds)
            int x = random.nextInt(w - width);
            int y = random.nextInt(h - height);

            // Random choice: rectangle or oval
            boolean isRectangle = random.nextBoolean();

            if (isRectangle) {
                g2.fillRect(x, y, width, height);
            } else {
                g2.fillOval(x, y, width, height);
            }
        }

        g2.dispose();
    }
}
