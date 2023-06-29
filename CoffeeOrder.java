import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code CoffeeOrder} class represents an order that contains multiple coffees.
 * It provides methods for adding coffees to the order, retrieving the order date,
 * calculating the total cost, and printing the order receipt.
 */
public class CoffeeOrder {
    private List<Coffee> coffees;
    private LocalDateTime orderDate;

    /**
     * Constructs a {@code CoffeeOrder} object with the current date and time.
     * The order starts with an empty list of coffees.
     */
    public CoffeeOrder() {
        coffees = new ArrayList<>();
        orderDate = LocalDateTime.now();
    }

    /**
     * Constructs a {@code CoffeeOrder} object with the specified order date.
     * The order starts with an empty list of coffees.
     *
     * @param orderDate The date and time of the coffee order.
     */
    public CoffeeOrder(LocalDateTime orderDate) {
        coffees = new ArrayList<>();
        this.orderDate = orderDate;
    }

    /**
     * Adds a coffee to the order.
     *
     * @param c The coffee to add to the order.
     */
    public void addCoffee(Coffee c) {
        coffees.add(c);
    }

    /**
     * Retrieves the list of coffees in the order.
     *
     * @return A list of coffees in the order.
     */
    public List<Coffee> getCoffees() {
        return coffees;
    }

    /**
     * Retrieves the date and time of the coffee order.
     *
     * @return The date and time of the coffee order.
     */
    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    /**
     * Calculates the total cost of the coffee order.
     *
     * @return The total cost of the coffee order.
     */
    public double getTotal() {
        double total = 0;
        for (Coffee coffee : coffees) {
            total += coffee.getCost();
        }
        return total;
    }

    /**
     * Prints the order receipt including the order date, individual coffee details, and the total cost.
     *
     * @return The order receipt as a formatted string.
     */
    public String printOrder() {
        StringBuilder order = new StringBuilder("ORDER RECEIPT\n");
        order.append(String.format("Timestamp: %s%n", orderDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mma"))));
        for (int i = 0; i < coffees.size(); i++) {
            Coffee coffee = coffees.get(i);
            Intensity intensity = (Intensity) coffee.getIntensity();
            String intensityName = (intensity != null) ? intensity.getName() : "Unknown";
            order.append(String.format("Item %d: %s - Intensity: %s - %.2f%n", i + 1, coffee.printCoffee(), intensityName, coffee.getCost()));
        }
        order.append(String.format("TOTAL = %.2f%n", getTotal()));
        return order.toString();
    }
}
