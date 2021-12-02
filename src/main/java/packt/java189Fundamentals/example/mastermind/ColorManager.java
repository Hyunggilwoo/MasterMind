package packt.java189Fundamentals.example.mastermind;

/*
* There are several algorithms to select the color.
* Player selects a variation and looks at all previous guesses,
* assuming that the selected variation is the secret.
* If the responses to the rows they already made are the same for
* this variation as for the unknown secret in the game, then it
* is reasonable to try this variation.
* Then this variation is certainly not the variation that was
* hidden.
*
*/

/*
* User has to know where the color was and has to guess the next
* variation coming.
*@requires: Guesser code will not create and store all the possible
* variations ahead. Right now, color can appear more than one in
* variation.
*
* The color will be ordered based on a number
* ex: 000, 001, 002, 003, 004... n.
* The guesser will generate the order of the colors.
*/


import java.util.Random;

/**
 * Give the first color to the caller.
 * Give the next color that follows a given color.
 */
public class ColorManager {

    /**
     * Keeps track of the number of Colored pins.
     */
    final protected int nrColors;

    public static final int choice = 6;

    /**
     *
     * @param nrColors
     */
    public ColorManager(int nrColors) {
        this.nrColors = nrColors;
        ...
    }
    /**
     *
     * @return a color object.
     */
    protected Color newColor() {
        return new Color();
    }

    /**
     * Returns a randomnly ordered colored variations.
     * @return
     */
    private Color[] createOrders() {
        Color[] colors = new Color[nrColors];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = newColor();
        }
        return colors;
    }

    /**
     * Generates an ordering of the colored object array. It generates
     * the color in a random order, which makes it possible to
     * change the color.
     * @return
     */
    public Color[] generateOrders() {
        Random r = new Random();
        int number = r.nextInt(choice);
    }
    /*
     * If the next indicies of a list contains next color object,
     * return true (if otherwise, return false).
     */
    public boolean isThereNextColor() {
        return true;
    }

}
