package packt.java189Fundamentals.example.mastermind;

public abstract class Guesser {

    protected final Table table;
    private final ColorManager manager;
    protected final Color[] lastGuess;

    public static final Color[] none = Color[]{Color.none};

    /**
     * Constructing a table.
     * @param table
     */
    public Guesser(Table table) {
        this.table = table;
        this.lastGuess = new Color[table.nrColumns];
        this.manager = table.manager;
    }

    /**
     * A guess matches if all rows in the table matches
     * the guess.
     * @param guess to match the rows.
     * @return true if all rows match
     */
    public boolean guessMatch(Color[] guess) {
        boolean result = true;
        for (Row row : table.rows) {
            if (!row.guessMatches(guess)) {
                result = false;
            }
        }
        return result;
    }

    abstract protected void setFirstGuess();

    /**
     * Returns the next functioning guess.
     * @return
     */
    protected Color[] nextGuess() {
        if (lastGuess[0] == null) {
            setFirstGuess();
            return lastGuess;
        } else {
            return nextNonFirstGuess();
        }
    }

    /**
     * Deals with the special case when the guess is not
     * the first one in the arrary.
     * @return
     */
    private Color[] nextNonFirstGuess() {
        Color[] result = new Color[]{null};
        int i = 0;
        boolean guessFound = false;
        while (i < table.nrColumns && !guessFound) {
            if (manager.isThereNextColor(lastGuess[i])) {
                lastGuess[i] = manager.nextColors(lastGuess[i]);
                guessFound = true;

            } else {
                lastGuess[i] = manager.firstColor();
                i++;
            }
        }
        if (guessFound) {
            result = lastGuess;
        }
        return result;
    }
}
