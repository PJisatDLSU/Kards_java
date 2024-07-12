package Display;

import javax.swing.*;
import java.awt.*;

public class MainDisplay {
    public static void main(String[] args) {
        // Create a new frame (window)
        JFrame mainFrame = new JFrame("Kards");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 800);
        mainFrame.setLayout(new BorderLayout());

        // Create a custom panel and add it to the frame
        CustomPanel panel = new CustomPanel("Total Amount");
        mainFrame.add(panel, BorderLayout.CENTER);

        // Create a panel for the buttons and set its layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 0, 10)); // 3 rows, 1 column, 10px vertical gap

        // Create buttons with the desired labels
        JButton button1 = new JButton("Cash");
        JButton button2 = new JButton("GCash");
        JButton button3 = new JButton("Beep");

        // Set the preferred size of the buttons to match the width of the rectangle
        Dimension buttonSize = new Dimension(450, 150);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);

        // Add action listeners to each button to open respective pages
        button1.addActionListener(e -> CashPage.createAndShowGUI(mainFrame));
        button2.addActionListener(e -> GCashPage.createAndShowGUI(mainFrame));
        button3.addActionListener(e -> BeepPage.createAndShowGUI(mainFrame));

        // Add buttons to the button panel
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        // Add the button panel to the frame at the bottom
        mainFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        mainFrame.setVisible(true);
    }
}
