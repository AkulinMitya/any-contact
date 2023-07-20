package gui;

import game.GameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class MainWindow extends JFrame{
    private JLabel timerLabel;
    private Timer timer;
    private final GameModel gameModel = GameModel.INSTANCE;
    private int secondsRemaining = 5;

    public MainWindow() {
        setTitle("Any contact");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().add(BorderLayout.NORTH, createWord(gameModel.word, 450, 250, "Verdana", 25));
        getContentPane().add(BorderLayout.CENTER, createTimerLabel(450, 250, "Verdana", 25));
        getContentPane().add(BorderLayout.SOUTH, createButtonsPanel());
    }

    private JLabel createTimerLabel(
            int width, int height, String font, int fontSize
    ) {
        timerLabel = new JLabel(secondsRemaining + " сек", SwingConstants.CENTER);
        timerLabel.setPreferredSize(new Dimension(width, height));
        timerLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        return timerLabel;
    }

    private JButton generateButton(
            String text, int width, int height, String font, int fontSize,
            ActionListener listener
    ) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(width, height));
        button.setFont(new Font(font, Font.PLAIN, fontSize));
        button.addActionListener(listener);

        return button;
    }

    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();

        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 65));

        JButton anyContactButton = generateButton(
                "Any contact!", 400, 200, "Verdana", 35,
                e1 -> {
                    // Запускаем таймер на 5 секунд
                    secondsRemaining = 5;
                    if (timer != null) {
                        timer.stop();
                    }

                    timer = new Timer(1000, e2 -> {
                        if (secondsRemaining > 0) {
                            timerLabel.setText(secondsRemaining + " сек");
                            secondsRemaining--;
                        } else {
                            timerLabel.setText("Таймер завершен!");
                            timer.stop();
                        }
                    });
                    timer.start();
                }
        );

        buttonsPanel.add(generateButton(
                "You guess the letter!", 400, 200, "Verdana", 35,
                e -> System.out.println("Hi")
        ));
        buttonsPanel.add(anyContactButton);

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
