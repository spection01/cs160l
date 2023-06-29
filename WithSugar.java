import java.util.List;

/**
 * The {@code WithSugar} class represents a coffee decorator that adds sugar to a base coffee.
 * It extends the {@code CoffeeDecorator} class and provides implementations for its methods.
 */
public class WithSugar extends CoffeeDecorator {
    public WithSugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        // Add the cost of sugar to the base coffee cost
        return super.getCost() + 0.15;
    }

    @Override
    public List<String> getIngredients() {
        // Add "Sugar" to the base coffee ingredients
        List<String> ingredients = super.getIngredients();
        ingredients.add("Sugar");
        return ingredients;
    }

    @Override
    public String printCoffee() {
        // Add "with sugar" to the base coffee name
        return super.printCoffee() + " with sugar";
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