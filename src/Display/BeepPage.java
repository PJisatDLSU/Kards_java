package Display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class BeepPage {
    public static void createAndShowGUI(JFrame mainFrame) {
        JFrame frame = new JFrame("Beep Screen");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setLayout(new BorderLayout());

        // Create a custom panel for the Beep page
        CustomPanel panel = new CustomPanel("Beep");
        frame.add(panel, BorderLayout.NORTH);

        // Create a panel for the text field and back button
        JPanel contentPanel = new JPanel(new BorderLayout());

        // Create a text field for inputting numbers
        JTextField textField = createNumberTextField();

        // Create a panel for the text field and label
        JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        textFieldPanel.add(new JLabel("Enter Amount:"));
        textFieldPanel.add(textField);

        // Add space between the custom panel and the text input
        contentPanel.add(Box.createVerticalStrut(350), BorderLayout.NORTH);
        contentPanel.add(textFieldPanel, BorderLayout.CENTER);

        // Create a back button
        JButton backButton = new JButton("Add Transaction");
        backButton.setPreferredSize(new Dimension(450, 50));
        backButton.addActionListener(e -> {
            frame.dispose();
            mainFrame.setVisible(true);
        });
        contentPanel.add(backButton, BorderLayout.SOUTH);

        // Add content panel to the Beep page frame
        frame.add(contentPanel, BorderLayout.CENTER);

        // Make the main frame invisible and the Beep page frame visible
        mainFrame.setVisible(false);
        frame.setVisible(true);
    }

    private static JTextField createNumberTextField() {
        JTextField textField = new JTextField(20);
        textField.setHorizontalAlignment(JTextField.CENTER);

        // Limit input to digits and decimal point
        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE) ||
                        (c == '.' && !textField.getText().contains(".")))) {
                    evt.consume();
                }
            }
        });

        return textField;
    }
}
