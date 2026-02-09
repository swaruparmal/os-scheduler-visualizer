import javax.swing.*;
import java.awt.*;

public class GanttChartPanel extends JPanel {

    private int[] bt;

    public GanttChartPanel(int[] bt) {
        this.bt = bt;
        setPreferredSize(new Dimension(500, 150));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 20;
        int y = 50;
        int scale = 20; // width multiplier

        int currentTime = 0;

        for (int i = 0; i < bt.length; i++) {

            int width = bt[i] * scale;

            // draw rectangle
            g.drawRect(x, y, width, 40);

            // draw process label
            g.drawString("P" + (i + 1), x + width / 2 - 5, y + 25);

            // draw time below
            g.drawString(String.valueOf(currentTime), x, y + 60);

            currentTime += bt[i];
            x += width;
        }

        // final time
        g.drawString(String.valueOf(currentTime), x, y + 60);
    }
}

