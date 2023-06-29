import java.util.List;

/**
 * The {@code Coffee} interface represents a coffee object with various properties and behaviors.
 * It defines methods to get the cost, ingredients, name, and intensity of the coffee.
 */
public interface Coffee {

    /**
     * Retrieves the cost of the coffee.
     *
     * @return The cost of the coffee.
     */
    double getCost();

    /**
     * Retrieves the ingredients of the coffee.
     *
     * @return A list of ingredients of the coffee.
     */
    List<String> getIngredients();

    /**
     * Returns a string representation of the coffee's name.
     *
     * @return The name of the coffee.
     */
    String printCoffee();

    /**
     * Retrieves the intensity of the coffee.
     *
     * @return The intensity of the coffee.
     */

    Object getIntensity();

    /**
     * Sets the intensity of the coffee.
     *
     * @param intensity The intensity to set for the coffee.
     */

    void setIntensity(Intensity intensity);

    /**
     * Returns a string representation of the coffee's name and intensity.
     * This method is optional and can return {@code null} if not implemented.
     *
     * @return The name and intensity of the coffee.
     */
    default String printCoffeeWithIntensity() {
        return null;
    }
}