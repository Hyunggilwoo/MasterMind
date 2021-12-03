package packt.java189Fundamentals.example.mastermind;

import java.util.Arrays;

public class Row {

    final Color[] positions;
    protected int matchedPositions;
    protected int matchedColors;

    /**
     * Row refers to the total length of Color objects being stored.
     * @param positions total length of the Colors object.
     */
    public Row(Color[] positions) {
        // copyOf() method invokes System.arraycopy
        this.positions = Arrays.copyOf(positions, positions.length);
    }

    /**
     * Clones a row from another row.
     * @param cloneFrom an original copy of Row.
     */
    protected Row(Row cloneFrom) {
        this(cloneFrom.positions);
        setMatch(cloneFrom.matchedPositions, cloneFrom.matchedColors);
    }

    /**
     * Setting the location for the position and the colors.
     * @param matchedPositions position we are comparing to.
     * @param matchedColors Color we are matching the guess to.
     */
    public void setMatch(int matchedPositions, int matchedColors) {
        if (matchedColors + matchedPositions > positions.length) {
            throw new IllegalArgumentException (
                    "Number of matches cannot be more than the position.");
        }
        this.matchedPositions = matchedPositions;
        this.matchedColors = matchedColors;
    }

    /**
     * Decides if a guess matches the actual row.
     * pre: cannot be null or zero?
     * @param guess the number of rows.
     */
    public boolean guessMatches(Color[] guess) {
        return nrMatchingColor(guess) == matchedColors &&
                nrMatchingPositions(guess) == matchedPositions;
    }

    /**
     * Counting the number of color
     * @param guess comparing to the color combination.
     * @return
     */
    public int nrMatchingColor(Color[] guess) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            for (int j = 0; j < positions.length; j++) {
                if (i != j && guess[i] == positions[j]) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * Tells the number of matching color to the current row.
     * @param guess makes the guessing color.
     * @return the matching number of count.
     */
    public int nrMatchingPositions(Color[] guess) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == positions[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * Outputs the correct number of column to the user.
     * @return
     */
    public int nrOfColumn() {
        return positions.length;
    }
}
