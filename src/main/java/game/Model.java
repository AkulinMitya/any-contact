package game;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model {
    private static final PropertyChangeSupport support = new PropertyChangeSupport(Model.class);
    public static String word = "";
    private static int countOfChars = 1;

    private Model() {}

    public static void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public static String wordCondition() {
        if (countOfChars == word.length() || word.length() <= 1) {
            SwingUtilities.invokeLater(
                    () -> support.firePropertyChange("end", false, true)
            );
            countOfChars = 1;
            return word;
        }

        return word.substring(0, countOfChars++);
    }
}
