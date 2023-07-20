package game;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public static final Model INSTANCE = new Model();
    private final String word = "Tarzan";
    private int countOfChars = 1;

    private Model() {}

    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public String wordCondition() {
        if (countOfChars == word.length()) {
            support.firePropertyChange("end", false, true);
            return "word: \"" + word + "\"";
        }

        return word.substring(0, countOfChars++);
    }
}
