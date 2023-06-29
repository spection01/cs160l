import java.util.List;

public class WithHotWater extends CoffeeDecorator {
    public WithHotWater(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.0;
    }

    @Override
    public List<String> getIngredients() {
        // Add "Hot Water" to the base coffee ingredients
        List<String> ingredients = super.getIngredients();
        ingredients.add("Hot water");
        return ingredients;
    }

    @Override
    public String printCoffee() {
        // Add "with hot water" to the base coffee name
        return super.printCoffee() + " with hot water";
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
        return null;
    }
}