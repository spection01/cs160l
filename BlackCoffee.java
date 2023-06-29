import java.util.List;

/**
 * The {@code BlackCoffee} class represents a black coffee, which is a type of coffee with no added ingredients.
 * It implements the {@code Coffee} interface and provides implementations for its methods.
 */
public class BlackCoffee implements Coffee {
    private Object intensity;

    @Override
    public double getCost() {
        return 1.0;
    }

    @Override
    public List<String> getIngredients() {
        return null;
    }

    @Override
    public String printCoffee() {
        return "A black coffee";
    }

    @Override
    public Object getIntensity(){
        return intensity;
    }

    @Override
    public void setIntensity(Intensity selectedIntensity) {
    this.intensity = intensity;
    }

    @Override
    public String printCoffeeWithIntensity() {
        return getIntensity().toString();
    }
}
