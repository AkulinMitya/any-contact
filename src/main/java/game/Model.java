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

    private static void clear() {
        countOfChars = 1;
        for (PropertyChangeListener listener : support.getPropertyChangeListeners()) {
            support.removePropertyChangeListener(listener);
        }
    }

    public static String wordCondition() {
        if (countOfChars == word.length() || word.length() <= 1) {
            clear();
            SwingUtilities.invokeLater(
                    () -> support.firePropertyChange("end", false, true)
            );
            return word;
        }

        return word.substring(0, countOfChars++);
    }
}
