package gui;

import game.Model;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JFrame implements PropertyChangeListener {
    private final int secondsRemaining = 2;
    private final String font = "Verdana";
    private final JButton guessButton = generateGuessButton(400, 200, 35);
    private final JButton contactButton = generateContactButton(400, 200, 35);
    private JLabel timerLabel = createTimerLabel(450, 250, 35);
    private JLabel wordLabel = createWord(Model.wordCondition(), 450, 250, 65);
    private Timer timer;

    public View() {
        setTitle("Any contact");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().add(BorderLayout.NORTH, wordLabel);
        getContentPane().add(BorderLayout.CENTER, timerLabel);
        getContentPane().add(BorderLayout.SOUTH, createButtonsPanel());
    }

    private JLabel createTimerLabel(int width, int height, int fontSize) {
        timerLabel = new JLabel(secondsRemaining + " sec", SwingConstants.CENTER);
        timerLabel.setPreferredSize(new Dimension(width, height));
        timerLabel.setFont(new Font(font, Font.PLAIN, fontSize));

        timerLabel.setBackground(Color.WHITE);
        timerLabel.setForeground(Color.BLACK);
        timerLabel.setOpaque(true);

        return timerLabel;
    }

    private JButton generateGuessButton(int width, int height, int fontSize) {
        JButton button = new JButton("letter guessed");

        button.setPreferredSize(new Dimension(width, height));
        button.setFont(new Font(font, Font.PLAIN, fontSize));
        button.setEnabled(false);

        button.addActionListener(e -> wordUpdate());

        return button;
    }

    private JButton generateContactButton(int width, int height, int fontSize) {
        JButton button = new JButton("any contact");

        button.setPreferredSize(new Dimension(width, height));
        button.setFont(new Font(font, Font.PLAIN, fontSize));

        button.addActionListener(
                e1 -> {
                    final Integer[] tempSecondsRemaining = {secondsRemaining};
                    if (timer != null) {
                        timer.stop();
                    }
                    this.guessButton.setEnabled(false);
                    timerLabel.setText(tempSecondsRemaining[0]-- + " sec");

                    timer = new Timer(1000, e2 -> {
                        if (tempSecondsRemaining[0] > 0) {
                            timerLabel.setText(tempSecondsRemaining[0] + " sec");
                            tempSecondsRemaining[0]--;
                        } else {
                            timerLabel.setText("Time out!");
                            timer.stop();

                            this.guessButton.setEnabled(true);
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

        buttonsPanel.add(guessButton);
        buttonsPanel.add(contactButton);

        return buttonsPanel;
    }

    private void wordUpdate() {
        wordLabel.setText(Model.wordCondition());
        wordLabel.repaint();
        guessButton.setEnabled(false);
    }

    private JLabel createWord(String text, int width, int height, int fontSize) {
        wordLabel = new JLabel(text, SwingConstants.CENTER);

        wordLabel.setPreferredSize(new Dimension(width, height));
        wordLabel.setFont(new Font(font, Font.BOLD, fontSize));

        return wordLabel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        int confirmed = JOptionPane.showOptionDialog(
                null,
                "word: \"" + Model.word + "\"",
                "Game over",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"Restart", "Exit"},
                null
        );

        if (confirmed == JOptionPane.NO_OPTION) {
            dispose();
            System.exit(0);
        } else {
            dispose();
            new Setup().start();
        }
    }
}
