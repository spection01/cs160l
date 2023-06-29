import java.util.List;

/**
 * The {@code Espresso} class represents an espresso coffee.
 * It implements the {@code Coffee} interface and provides methods
 * to get the cost, ingredients, and intensity of the espresso.
 */
public class Espresso implements Coffee {
    private double cost;
    private List<String> ingredients;
    private Object intensity;

    public Espresso() {


    }

    @Override
    public double getCost() {

        return 1.75;
    }

    @Override
    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String printCoffee() {
        return "Espresso";
    }

    @Override
    public Object getIntensity() {
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