package gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
    public MainWindow() {
        super("Any contact");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);

        getContentPane().add(BorderLayout.NORTH, createWord(
                "Yura", 450, 250, "Verdana", 25
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
        buttonsPanel.add(generateButton(
                "You guess the letter!", 450, 250, "Verdana", 25)
        );
        buttonsPanel.add(generateButton(
                "Any Contact?!", 450, 250, "Verdana", 25)
        );

        return buttonsPanel;
    }

    private JLabel createWord(
            String text, int width, int height, String font, int fontSize
    ) {
        JLabel word = new JLabel(text, SwingConstants.CENTER);
        word.setPreferredSize(new Dimension(width, height));
        word.setFont(new Font(font, Font.PLAIN, fontSize));

        return word;
    }
}
