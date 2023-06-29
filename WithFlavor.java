import java.util.List;

/**
 * The {@code WithFlavor} class represents a coffee decorator that adds a flavor syrup to a base coffee.
 * It extends the {@code CoffeeDecorator} class and provides implementations for its methods.
 */
public class WithFlavor extends CoffeeDecorator {

    /**
     * The available flavor syrups.
     */
    enum Syrup {
        CARAMEL,
        MOCHA,
        VANILLA
    }

    private Syrup flavor;

    /**
     * Constructs a new {@code WithFlavor} object with the specified base coffee and flavor syrup.
     *
     * @param c the base coffee to decorate with the flavor syrup
     * @param s  the flavor syrup to add to the coffee
     */

    public WithFlavor(Coffee c, Syrup s) {
        super(c);
        flavor = s;
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.35;
    }

    @Override
    public List<String> getIngredients() {
        return null;
    }

    @Override
    public String printCoffee() {
        return super.printCoffee() + " with " + flavor;
    }

    @Override
    public Object getIntensity() {
        return null;
    }

    @Override
    public void setIntensity(Intensity selectedIntensity) {

    }

    @Override
    public String printCoffeeWithIntensity() {
        return getIntensity().toString();
    }
}
