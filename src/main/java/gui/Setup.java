package gui;

import game.Model;

import javax.swing.*;
import java.awt.*;

public class Setup {
    public void start() {
        Model model = Model.INSTANCE;

        String word = JOptionPane.showInputDialog(null, "Enter word");
        while (word.length() <= 1) {
            word = JOptionPane.showInputDialog(null, "Enter word");
        }
        model.setWord(word);

        SwingUtilities.invokeLater(() -> {
            View view = new View();
            model.addListener(view);
            view.pack();
            view.setVisible(true);
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
        });
    }
}
