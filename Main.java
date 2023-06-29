import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
import java.io.*;

/**
 * The Main class represents the main entry point of the Java Coffee Co. application.
 * It allows users to place coffee orders, manage inventory, and update order logs.
 */
public class Main {
    private static Map<String, Integer> inventory = new TreeMap<String, Integer>();
    private static List<CoffeeOrder> orders = new ArrayList<CoffeeOrder>();
    private static String logFile = "OrderLog.txt";
    private static String inventoryFile = "Inventory.txt";

    /**
     * The main method of the application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Java Coffee Co.!");
        inventory = readInventory(inventoryFile);
        System.out.println("Current inventory:");
        printInventory();
        try (Scanner input = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                System.out.println("Please select an option:");
                System.out.println("1. New Order");
                System.out.println("2. Reload Inventory");
                System.out.println("3. Update Inventory");
                System.out.println("4. Update Order Log");
                System.out.println("5. Exit Application");

                int option = 0;
                while (option < 1 || option > 5) {
                    if (!input.hasNextInt()) {
                        System.out.println("Please enter a valid number.");
                        input.nextLine();
                    } else {
                        option = input.nextInt();
                        if (option < 1 || option > 5) System.out.println("Please enter a valid option.");
                    }
                }
                input.nextLine(); // Consume the newline character after reading the option.

                switch (option) {
                    case 1:
                        CoffeeOrder order = buildOrder();
                        orders.add(order);
                        System.out.println(order.printOrder());
                        break;
                    case 2:
                        inventory = readInventory(inventoryFile);
                        System.out.println("Current inventory:");
                        printInventory();
                        break;
                    case 3:
                        writeInventory(inventoryFile);
                        break;
                    case 4:
                        writeOrderLog(logFile);
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Please enter a valid option.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        if (!orders.isEmpty()) writeOrderLog(logFile);
    }

    /**
     * Builds a coffee order based on user input.
     *
     * @return The built CoffeeOrder object.
     */
    private static CoffeeOrder buildOrder() {
        CoffeeOrder order = new CoffeeOrder();
        try {
            Scanner input = new Scanner(System.in);
            boolean addCoffee = true;
            System.out.println("Select intensity level:");
            System.out.println("\t1. Mild");
            System.out.println("\t2. Medium");
            System.out.println("\t3. Strong");

            // Create Intensity objects
            Intensity mild = new Intensity("Mild");
            Intensity medium = new Intensity("Medium");
            Intensity strong = new Intensity("Strong");

            int intensityOption = 0;
            while (intensityOption < 1 || intensityOption > 3) {
                if (!input.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    input.nextLine();
                } else {
                    intensityOption = input.nextInt();
                    if (intensityOption < 1 || intensityOption > 3) {
                        System.out.println("Please enter a valid option.");
                    }
                }
            }
            input.nextLine(); // Consume the newline character after reading the option.

            // Assign the selected intensity level to the coffee object
            Intensity selectedIntensity;
            switch (intensityOption) {
                case 1:
                    selectedIntensity = mild;
                    break;
                case 2:
                    selectedIntensity = medium;
                    break;
                case 3:
                    selectedIntensity = strong;
                    break;
                default:
                    selectedIntensity = medium; // Default to medium intensity
            }

            Coffee coffee = null;

            while (addCoffee) {
                // prompt user to select base coffee type
                System.out.println("Select coffee type:");
                System.out.println("\t1. Black Coffee");
                System.out.println("\t2. Espresso");

                int option = 0;
                while (option < 1 || option > 2) {
                    if (!input.hasNextInt()) {
                        System.out.println("Please enter a valid number.");
                        input.nextLine();
                    } else {
                        option = input.nextInt();
                        if (option < 1 || option > 2) System.out.println("Please enter a valid option.");
                    }
                }
                input.nextLine(); // nextInt() doesn't consume newline
                if (option == 2) {
                    // Espresso is a specific case
                    coffee = new Espresso();
                } else {
                    // make BlackCoffee the default case
                    coffee = new BlackCoffee();
                }
                coffee.setIntensity(selectedIntensity);

                // prompt user for any customizations
                while (option != 0) {
                    System.out.println(String.format("Coffee brewing: %s.", coffee.printCoffee()));
                    System.out.println("Would you like to add anything to your coffee?");
                    System.out.println("\t1. Flavored Syrup");
                    System.out.println("\t2. Hot Water");
                    System.out.println("\t3. Milk");
                    System.out.println("\t4. Sugar");
                    System.out.println("\t5. Whipped Cream");
                    System.out.println("\t0. NO - Finish Coffee");

                    while (!input.hasNextInt()) {
                        System.out.println("Please enter a valid number.");
                        input.nextLine();
                    }
                    option = input.nextInt();
                    input.nextLine();
                    switch (option) {
                        case 1:
                            System.out.println("Please select a flavor:");
                            for (WithFlavor.Syrup flavor : WithFlavor.Syrup.values()) {
                                System.out.println("\t" + String.format("%d. %s", flavor.ordinal() + 1, flavor));
                            }
                            int max = WithFlavor.Syrup.values().length;
                            option = 0;
                            while (option < 1 || option > max) {
                                if (!input.hasNextInt()) {
                                    System.out.println("Please enter a valid number.");
                                    input.nextLine();
                                } else {
                                    option = input.nextInt();
                                    if (option < 1 || option > max) System.out.println("Please enter a valid option.");
                                }
                            }
                            input.nextLine();
                            WithFlavor.Syrup flavor = WithFlavor.Syrup.values()[option - 1];
                            String flavorKey = flavor.toString();
                            if (isInInventory(flavorKey)) {
                                coffee = new WithFlavor(coffee, flavor);
                                inventory.put(flavorKey, inventory.get(flavorKey) - 1);
                            } else {
                                System.out.println("No " + flavorKey + " syrup left in inventory.");
                            }
                            break;
                        case 2:
                            if (isInInventory("Hot Water")) {
                                coffee = new WithHotWater(coffee);
                                inventory.put("Hot Water", inventory.get("Hot Water") - 1);
                            } else {
                                System.out.println("No hot water left in inventory.");
                            }
                            break;
                        case 3:
                            if (isInInventory("Milk")) {
                                coffee = new WithMilk(coffee);
                                inventory.put("Milk", inventory.get("Milk") - 1);
                            } else {
                                System.out.println("No milk left in inventory.");
                            }
                            break;
                        case 4:
                            if (isInInventory("Sugar")) {
                                coffee = new WithSugar(coffee);
                                inventory.put("Sugar", inventory.get("Sugar") - 1);
                            } else {
                                System.out.println("No sugar left in inventory.");
                            }
                            break;
                        case 5:
                            if (isInInventory("Whipped Cream")) {
                                coffee = new WithWhippedCream(coffee);
                                inventory.put("Whipped Cream", inventory.get("Whipped Cream") - 1);
                            } else {
                                System.out.println("No whipped cream left in inventory.");
                            }
                            break;
                        default:
                            if (option != 0) System.out.println("Please enter a valid option.");
                            break;
                    }
                }
                order.addCoffee(coffee);

                System.out.println("Would you like to order another coffee (Y or N)?");
                String yn = input.nextLine();
                while (!(yn.equalsIgnoreCase("N") || yn.equalsIgnoreCase("Y"))) {
                    System.out.println("Please enter Y or N.");
                    yn = input.nextLine();
                }
                addCoffee = !yn.equalsIgnoreCase("N");
            }
        } catch (Exception e) {
            System.out.println("Error building order: " + e.getMessage());
        }
        return order;
    }

    /**
     * Reads the inventory data from a file and returns it as a Map.
     *
     * @param filePath The path of the inventory file.
     * @return The inventory data as a Map.
     */
    private static Map<String, Integer> readInventory(String filePath) {
        Map<String, Integer> inventory = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" : ");
                if (parts.length == 2) {
                    String ingredient = parts[0].trim();
                    int quantity = Integer.parseInt(parts[1].trim());
                    inventory.put(ingredient, quantity);
                } else {
                    System.out.println("Invalid inventory data: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Inventory file not found.");
        } catch (Exception e) {
            System.out.println("Error reading inventory: " + e.getMessage());
        }

        return inventory;
    }

    /**
     * Writes the inventory data to a file.
     *
     * @param filePath The path of the inventory file.
     */
    private static void writeInventory(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }
            System.out.println("Inventory successfully updated.");
        } catch (IOException e) {
            System.out.println("Error writing inventory: " + e.getMessage());
        }
    }

    private static List<CoffeeOrder> readOrderLog(String filePath) {
        return null;
    }

    /**
     * Writes the order log to a file.
     *
     * @param filePath The path of the order log file.
     */
    private static void writeOrderLog(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (CoffeeOrder order : orders) {
                writer.write(order.printOrder());
                writer.newLine();

            }
            orders.clear();
        } catch (Exception e) {
            System.out.println("Error writing order log: " + e.getMessage());
        }
    }

    /**
     * Checks if an ingredient is available in the inventory.
     *
     * @param ingredient The ingredient to check.
     * @return True if the ingredient is available, false otherwise.
     */
    private static boolean isInInventory(String ingredient) {
        return inventory.containsKey(ingredient) && inventory.get(ingredient) > 0;
    }

    /**
     * Prints the current inventory.
     */
    private static void printInventory() {
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}