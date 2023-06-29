import java.util.List;

/**
 * The {@code WithMilk} class represents a decorator for adding milk to a coffee.
 * It extends the {@link CoffeeDecorator} class and provides additional functionality
 * for calculating the cost, getting the ingredients, and printing the coffee with milk.
 */
public class WithMilk extends CoffeeDecorator {
    private Intensity intensity;

    /**
     * Constructs a {@code WithMilk} object with the specified coffee and intensity.
     *
     * @param coffee    The base coffee to add milk to.
     * @param intensity The intensity of the coffee with milk.
     */
    public WithMilk(Coffee coffee, Intensity intensity) {
        super(coffee);
        this.intensity = intensity;
    }

    public WithMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        // Add the cost of milk to the base coffee cost
        return super.getCost() + 0.55;
    }

    @Override
    public List<String> getIngredients() {
        // Add "Milk" to the base coffee ingredients
        List<String> ingredients = super.getIngredients();
        ingredients.add("Milk");
        return ingredients;
    }

    @Override
    public String printCoffee() {
        // Add "with milk" to the base coffee name
        return super.printCoffee() + " with milk";
    }

    @Override
    public Intensity getIntensity() {
        return intensity;
    }

    @Override
    public void setIntensity(Intensity selectedIntensity) {
        this.intensity = selectedIntensity;
    }

    @Override
    public String printCoffeeWithIntensity() {
        return super.printCoffeeWithIntensity() + " with milk (" + intensity.getName() + ")";
    }
}
