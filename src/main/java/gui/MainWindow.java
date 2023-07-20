package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{
    public MainWindow() {
        setTitle("Any contact");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().add(BorderLayout.NORTH, createWord(
                "w...", 450, 250, "Verdana", 50
        ));
        getContentPane().add(BorderLayout.SOUTH, createButtonsPanel());
    }

    private JButton generateButton(
            String text, int width, int height, String font, int fontSize
    ) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(width, height));
        button.setFont(new Font(font, Font.PLAIN, fontSize));

        return button;
    }

    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();

        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 65));

        buttonsPanel.add(generateButton(
                "any contact", 400, 200, "Verdana", 35)
        );
        buttonsPanel.add(generateButton(
                "letter guessed", 400, 200, "Verdana", 35)
        );

        return buttonsPanel;
    }

    private JLabel createWord(
            String text, int width, int height, String font, int fontSize
    ) {
        JLabel word = new JLabel(text, SwingConstants.CENTER);

        word.setPreferredSize(new Dimension(width, height));
        word.setFont(new Font(font, Font.BOLD, fontSize));

        word.setBackground(Color.WHITE);
        word.setForeground(Color.DARK_GRAY);
        word.setOpaque(true);

        return word;
    }
}
