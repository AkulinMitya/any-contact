package gui;

import game.GameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class MainWindow extends JFrame {
//    private PropertyChangeListener
    private int secondsRemaining = 5;
    private final String font = "Verdana";
    private final GameModel gameModel = GameModel.INSTANCE;
    private JButton guessButton = generateGuessButton();
    private JLabel timerLabel = createTimerLabel(450, 250, 35);
    private JLabel wordLabel = createWord(gameModel.wordCondition(), 450, 250, 65);
    private Timer timer;

    public MainWindow() {
        setTitle("Any contact");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().add(BorderLayout.NORTH, wordLabel);
        getContentPane().add(BorderLayout.CENTER, timerLabel);
        getContentPane().add(BorderLayout.SOUTH, createButtonsPanel());
    }

    private JLabel createTimerLabel(
            int width, int height, int fontSize
    ) {
        timerLabel = new JLabel(secondsRemaining + " sec", SwingConstants.CENTER);
        timerLabel.setPreferredSize(new Dimension(width, height));
        timerLabel.setFont(new Font(font, Font.PLAIN, fontSize));

        return timerLabel;
    }

    private JButton generateGuessButton() {
        guessButton = new JButton("You guess the letter!");

        guessButton.setPreferredSize(new Dimension(400, 200));
        guessButton.setFont(new Font(font, Font.PLAIN, 35));
        guessButton.setEnabled(false);
        guessButton.addActionListener(e -> wordUpdate());

        return guessButton;
    }

    private JButton generateContactButton() {
        JButton button = new JButton("Any contact!");
        button.setPreferredSize(new Dimension(400, 200));
        button.setFont(new Font(font, Font.PLAIN, 35));
        button.addActionListener(
                e1 -> {
                    secondsRemaining = 5;
                    if (timer != null) {
                        timer.stop();
                    }
                    guessButton.setEnabled(false);

                    timer = new Timer(1000, e2 -> {
                        if (secondsRemaining > 0) {
                            timerLabel.setText(secondsRemaining + " sec");
                            secondsRemaining--;
                        } else {
                            timerLabel.setText("Time out!");
                            timer.stop();

                            guessButton.setEnabled(true);
                        }
                    });
                    timer.start();
                }
        );

        return button;
    }

    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();

        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 65));

        buttonsPanel.add(generateGuessButton());
        buttonsPanel.add(generateContactButton());

        return buttonsPanel;
    }

    private void wordUpdate() {
        wordLabel.setText(gameModel.wordCondition());
        wordLabel.repaint();
        guessButton.setEnabled(false);
    }

    private JLabel createWord(String text, int width, int height, int fontSize) {
        wordLabel = new JLabel(text, SwingConstants.CENTER);

        wordLabel.setPreferredSize(new Dimension(width, height));
        wordLabel.setFont(new Font(font, Font.BOLD, fontSize));

        wordLabel.setBackground(Color.WHITE);
        wordLabel.setForeground(Color.DARK_GRAY);
        wordLabel.setOpaque(true);

        return wordLabel;
    }
}
