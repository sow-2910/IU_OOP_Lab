package question8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class BarChartPanel extends JPanel {
    private int[] values; // array to store the 5 numbers
    private final int NUM_BARS = 5;
    private final int BAR_HEIGHT = 30;
    private final int BAR_MARGIN = 20;

    public BarChartPanel() {
        values = new int[NUM_BARS];
    }

    public void setValues(int[] newValues) {
        if (newValues.length == NUM_BARS) {
            this.values = newValues;
            repaint(); // redraw the panel
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // Find the maximum value to scale bars
        int maxValue = 0;
        for (int val : values) {
            if (val > maxValue) {
                maxValue = val;
            }
        }

        if (maxValue == 0) {
            maxValue = 100; // default scale if all values are 0
        }

        // Draw title
        g2.setColor(Color.BLACK);
        g2.drawString("Bar Chart", 20, 30);

        // Draw bars
        int startY = 60;
        Color[] barColors = { Color.BLACK, new Color(100, 100, 200), new Color(150, 0, 150), Color.GREEN,
                new Color(0, 180, 180) };

        for (int i = 0; i < NUM_BARS; i++) {
            int y = startY + i * (BAR_HEIGHT + BAR_MARGIN);

            // Calculate bar width based on value and panel width
            int barWidth = (int) ((double) values[i] / maxValue * (w - 100));

            // Draw label
            g2.setColor(Color.BLACK);
            g2.drawString("Bar " + (i + 1) + ":", 10, y + BAR_HEIGHT - 5);

            // Draw bar
            g2.setColor(barColors[i]);
            g2.fillRect(100, y, barWidth, BAR_HEIGHT);

            // Draw value label
            g2.setColor(Color.BLACK);
            g2.drawString(String.valueOf(values[i]), 100 + barWidth + 10, y + BAR_HEIGHT - 5);
        }

        g2.dispose();
    }
}
