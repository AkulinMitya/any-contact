package gui;

import game.Model;

import javax.swing.*;
import java.awt.*;

public class Setup {
    public void start() {
        String word = JOptionPane.showInputDialog(null, "Enter word");
        while (word.length() <= 1 || !word.matches("[a-zA-Z]+")) {
            word = JOptionPane.showInputDialog(null, "Enter word");
        }
        Model.word = word;

        SwingUtilities.invokeLater(() -> {
            View view = new View();
            Model.addListener(view);
            view.pack();
            view.setVisible(true);
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
        });
    }
}
