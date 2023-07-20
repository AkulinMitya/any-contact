import game.Model;
import gui.View;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {

            View view = new View();
            Model model = Model.INSTANCE;
            model.addListener(view);
            view.pack();
            view.setVisible(true);
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
        });
    }
}
