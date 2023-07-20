package gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
    public MainWindow() {
        super("My First GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);


        JButton button1 = new JButton("You guess the letter!");
        JButton button2 = new JButton("Any Contact?!");
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        JLabel word = new JLabel("Yura", SwingConstants.CENTER);
        getContentPane().add(BorderLayout.NORTH, word);
        getContentPane().add(BorderLayout.SOUTH, buttonsPanel);
    }
}
