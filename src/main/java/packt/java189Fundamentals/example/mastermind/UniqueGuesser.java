package packt.java189Fundamentals.example.mastermind;

import java.util.HashSet;

public class UniqueGuesser extends Guesser {

    public UniqueGuesser(Table table) {
        super(table);
    }

    /**
     * After the first color is selected, creates
     * the next guesses one after the other.
     */
    @Override
    protected void setFirstGuess() {
        int i = lastGuess.length - 1;
        for (var color = table.manager.firstColor();
            i >= 0; color = table.manager.nextColors(color)) {
            lastGuess[i--] = color;
        }
    }

    /**
     * Checks if the color contains duplicates of color.
     * @param guess
     * @return
     */
    private boolean isNotUnique(Color[] guess) {
        boolean result = false;
        final var alreadyPresent = new HashSet<Color>();
        for (final var color : guess) {
            if (alreadyPresent.contains(color)) {
                result = true;
            }
            alreadyPresent.add(color);
        }
        return result;
    }

}
