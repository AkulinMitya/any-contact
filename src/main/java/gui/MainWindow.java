package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{
    private JLabel timerLabel;
    private Timer timer;
    private int secondsRemaining;
    public MainWindow() {
        super("Any contact");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);

        secondsRemaining = 0;
        timerLabel = createTimerLabel(450, 250, "Verdana", 25);
        getContentPane().add(BorderLayout.NORTH, createWord("Yura", 450, 250, "Verdana", 25));
        getContentPane().add(BorderLayout.CENTER, timerLabel);
        getContentPane().add(BorderLayout.SOUTH, createButtonsPanel());
    }

    private JLabel createTimerLabel(
            int width, int height, String font, int fontSize
    ) {
        JLabel timerLabel = new JLabel("", SwingConstants.CENTER);
        timerLabel.setPreferredSize(new Dimension(width, height));
        timerLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        return timerLabel;
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
        JButton anyContactButton = generateButton(
                "Any Contact?!", 450, 250, "Verdana", 25
        );
        addAnyContactListener(anyContactButton);
        buttonsPanel.add(anyContactButton);

        return buttonsPanel;
    }

    private void addAnyContactListener(JButton anyContactButton){
        anyContactButton.addActionListener(e -> {
            // Запускаем таймер на 5 секунд
            secondsRemaining = 5;
            if (timer != null) {
                timer.stop();
            }

            timer = new Timer(1000, e1 -> {
                if (secondsRemaining > 0) {
                    timerLabel.setText("Осталось времени: " + secondsRemaining + " сек");
                    secondsRemaining--;
                } else {
                    timerLabel.setText("Таймер завершен!");
                    timer.stop();
                }
            });
            timer.start();
        });
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
