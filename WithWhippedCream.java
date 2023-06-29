import java.util.List;

/**
 * The {@code WithWhippedCream} class represents a coffee decorator that adds whipped cream to a base coffee.
 * It extends the {@code CoffeeDecorator} class and provides methods to get the cost, ingredients, and name of the coffee with whipped cream.
 */
public class WithWhippedCream extends CoffeeDecorator {
    public WithWhippedCream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        // Add the cost of whipped cream to the base coffee cost
        return super.getCost() + 0.25;
    }

    @Override
    public List<String> getIngredients() {
        // Add "Whipped Cream" to the base coffee ingredients
        List<String> ingredients = super.getIngredients();
        ingredients.add("Whipped cream");
        return ingredients;
    }

    @Override
    public String printCoffee() {
        // Add "with Whipped cream" to the base coffee name
        return super.printCoffee() + " with Whipped cream";
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