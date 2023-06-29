import java.util.List;

/**
 * The {@code CoffeeDecorator} class is an abstract base class for coffee decorators.
 * It implements the {@code Coffee} interface and provides common functionality for decorating coffee objects.
 */
public abstract class CoffeeDecorator implements Coffee {
    private Coffee coffee;

    /**
     * Constructs a new {@code CoffeeDecorator} object with the specified coffee to be decorated.
     *
     * @param c the coffee object to be decorated
     */
    public CoffeeDecorator(Coffee c) {
        coffee = c;
    }

    /**
     * Returns the cost of the decorated coffee.
     * This method delegates the call to the underlying coffee object.
     *
     * @return the cost of the decorated coffee
     */
    public double getCost() { return coffee.getCost(); }

    /**
     * Returns the ingredients of the decorated coffee.
     * This method delegates the call to the underlying coffee object.
     *
     * @return the ingredients of the decorated coffee
     */
    public List<String> getIngredients() {
        return null;
    }

    /**
     * Returns the string representation of the decorated coffee.
     * This method delegates the call to the underlying coffee object.
     *
     * @return the string representation of the decorated coffee
     */
    public String printCoffee() {
        return coffee.printCoffee();
    }
}
