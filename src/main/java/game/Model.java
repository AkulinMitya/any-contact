package game;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public static Model INSTANCE = new Model();
    private String word = "";
    private int countOfChars = 1;

    public void setWord(String word) {
        this.word = word;
    }

    private Model() {}

    public void clear() {
        INSTANCE = new Model();
    }

    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public String wordCondition() {
        if (countOfChars == word.length() || word.length() <= 1) {
            support.firePropertyChange("end", false, true);
            return "word: \"" + word + "\"";
        }

        return word.substring(0, countOfChars++);
    }
}
