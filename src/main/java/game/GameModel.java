package game;

public class GameModel {
    public static final GameModel INSTANCE = new GameModel();
    private final String word = "Yura";
    private int countOfChars = 1;

    private GameModel() {

    }

    public String wordCondition() {
        if (countOfChars == word.length() + 1) {
            return "Game over!";
        }

        return word.substring(0, countOfChars++);
    }
}
