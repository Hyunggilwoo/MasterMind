package packt.java189Fundamentals.example.mastermind;

/**
 * This prints out the table, the guesses, and how the game runs.
 * Similar to Row class, but it is necessary to create another class
 * because it separates the output concern from the core function
 * of Row.
 */
public class PrintableRow extends Row{

    public PrintableRow(Row row) {
        super(row);
    }

    /**
     * Returns the position of the color to the user.
     * @param i the index to look at.
     * @return the position at i.
     */
    public Color position(int i) {
        return positions[i];
    }

    /**
     * Returns the number of matching positions to the
     * guess to the user.
     * @return number of maching positions.
     */
    public int matchedPositions() {
        return matchedPositions;
    }

    /**
     * Returns the number of matching colors to the
     * user.
     * @return number of matching colors.
     */
    public int matchedColors() {
        return matchedColors;
    }
}
