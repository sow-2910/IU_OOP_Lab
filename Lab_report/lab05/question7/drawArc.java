package question7;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class drawArc extends JPanel {

    Random rand = new Random();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        int width = getWidth();
        int height = getHeight();

        int centerX = width / 2;
        int centerY = height / 2;

        int diameter = height;
        int radius = diameter / 10;

        int firstX = 0;
        int firstY = 0;

        Color color1 = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
        Color color2 = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));

        for (int i = 0; i < 10; i++) {
            g.setColor(color1);
            g.fillArc(firstX, firstY, diameter, diameter, 0, 360);
            firstX += radius;
            firstY += radius;
            diameter -= radius * 2;
            g.setColor(color2);
            g.fillArc(firstX, firstY, diameter, diameter, 0, 360);
            firstX += radius;
            firstY += radius;
            diameter -= radius * 2;
        }

    }
}