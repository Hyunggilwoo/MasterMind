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
     * Checks whether the guess matches the previous guesses
     * and their results on the Table:
     * @param guess to match the rows.
     * @return true if all rows match
     */
    private boolean guessMatch(Color[] guess) {
        boolean result = false;
        for (Row row : table.rows) {
            if (row.guessMatches(guess)) {
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
            return lastGuess;
        } else {
            return none;
        }
    }


}
