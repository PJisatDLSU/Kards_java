package Display;

import javax.swing.*;
import java.awt.*;

class CustomPanel extends JPanel {
    private String pageTitle;

    public CustomPanel(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public void setTitle(String title) {
        this.pageTitle = title;
        repaint(); // Ensure panel repaints to show updated title immediately
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smoother edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the color for the rectangle
        g2d.setColor(Color.LIGHT_GRAY);

        // Determine the dimensions and position of the rounded rectangle
        int x = 50;  // Adjust x position as needed
        int y = 50;  // Adjust y position as needed
        int width = getWidth() - 100;  // Width of the panel minus some padding
        int height = 150;  // Height of the rounded rectangle
        int arcWidth = 50;  // Arc width for rounded corners
        int arcHeight = 50;  // Arc height for rounded corners
        g2d.fillRoundRect(x, y, width, height, arcWidth, arcHeight);

        // Set the color for the text
        g2d.setColor(Color.BLACK);

        // Draw the page title at the center of the rectangle
        Font font = new Font("Serif", Font.BOLD, 24);
        g2d.setFont(font);
        FontMetrics metrics = g2d.getFontMetrics(font);
        int textX = x + (width - metrics.stringWidth(pageTitle)) / 2;
        int textY = y + (height - metrics.getHeight()) / 2 + metrics.getAscent();
        g2d.drawString(pageTitle, textX, textY);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 150);  // Adjust width and height as needed
    }
}
