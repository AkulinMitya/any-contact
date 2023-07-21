package game;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model {
    private static final PropertyChangeSupport support = new PropertyChangeSupport(Model.class);
    public static String word = "";
    private static int visibleSymbols = 0;

    private Model() {
    }

    public static void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    private static void clear() {
        visibleSymbols = 0;
        for (PropertyChangeListener listener : support.getPropertyChangeListeners()) {
            support.removePropertyChangeListener(listener);
        }
    }

    public static String wordCondition() {
        if (visibleSymbols == word.length() - 1) {
            SwingUtilities.invokeLater(() ->
                    {
                        support.firePropertyChange("end", false, true);
                        clear();
                    }
            );
            return word;
        }

        return word.substring(0, ++visibleSymbols);
    }
}
