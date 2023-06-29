/**
 * The {@code Intensity} class represents the intensity of a coffee.
 * It contains a name and a level to describe the intensity.
 */
public class Intensity {
    private String name;
    private int level;

    /**
     * Constructs a new {@code Intensity} object with the specified name.
     *
     * @param name the name of the intensity
     */
    public Intensity(String name) {
        this.name = name;
        this.level = level;
    }

    /**
     * Returns the name of the intensity.
     *
     * @return the name of the intensity
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the level of the intensity.
     *
     * @return the level of the intensity
     */
    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return name;
    }
}