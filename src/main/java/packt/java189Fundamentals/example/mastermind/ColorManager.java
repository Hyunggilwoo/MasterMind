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


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Give the first color to the caller.
 * Give the next color that follows a given color.
 */
public class ColorManager {

    /**
     * @requires nrColors > 0
     *
     */
    final protected int nrColors;

    /** Generates a place where one color connects to another color. */
    final protected Map<Color, Color> successor = new HashMap<>();
    public static final int choice = 6;

    /** It acts like the first node of a linkedList. */
    private Color first;

    /**
     * Generates the colored structure
     * @param nrColors the number of color present.
     */
    public ColorManager(int nrColors) {
        this.nrColors = nrColors;
        generateOrders();
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
     * @return the color in the array.
     */
    private Color[] createColors() {
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
    public void generateOrders() {
        Color[] colors = createColors();
        first = colors[0];
        for (int i = 0; i < colors.length; i++) {
            successor.put(colors[i], colors[i + 1]);
        }
    }

    /**
     * Returns the first color of the ordering.
     * @return the first Color of the object.
     */
    public Color firstColor() {
        return first;
    }
    /**
     * If the next indicies of a list contains next color object,
     * return true (if otherwise, return false).
     * @param color is the color that I want.
     * @return checks if the order contains the color.
     */
    public boolean isThereNextColor(Color color) {
        return successor.containsKey(color);
    }

    /**
     * Orders the color object to identify the color.
     * @param color is what I am interested.
     * @return color that I want to spend.
     */
    public Color nextColors(Color color) {
        return successor.get(color);
    }

    /*
    public Color nextColor(Color color) {
        Color result = null;
        if (!(color == Color.none)) {
            result color.get(color.indexOf(color) + 1);
        }
    }
     */
}
