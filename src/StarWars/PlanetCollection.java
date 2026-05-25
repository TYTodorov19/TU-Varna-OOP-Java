package StarWars;

/**
 * Represents a collection of planets.
 * This class hides the internal planet array and provides methods for planet operations.
 */
public class PlanetCollection {
    private Planet[] planets;
    private int count;

    /**
     * Creates a planet collection with fixed capacity.
     *
     * @param capacity maximum number of planets
     */
    public PlanetCollection(int capacity) {
        this.planets = new Planet[capacity];
        this.count = 0;
    }

    /**
     * Adds a planet if there is free space and the name is unique.
     *
     * @param planet the planet that will be added
     * @return true if the planet is added successfully, false otherwise
     */
    public boolean add(Planet planet) {
        if (count >= planets.length || findByName(planet.getName()) != null) {
            return false;
        }

        planets[count++] = planet;
        return true;
    }

    /**
     * Finds a planet by name.
     *
     * @param name the name of the planet
     * @return the found planet or null
     */
    public Planet findByName(String name) {
        for (int i = 0; i < count; i++) {
            if (planets[i].getName().equals(name)) {
                return planets[i];
            }
        }
        return null;
    }

    /**
     * Clears all planets from the collection.
     */
    public void clear() {
        this.planets = new Planet[planets.length];
        this.count = 0;
    }

    /**
     * Returns the internal array.
     *
     * @return array of planets
     */
    public Planet[] getItems() {
        return planets;
    }

    /**
     * Returns current number of planets.
     *
     * @return planet count
     */
    public int getCount() {
        return count;
    }
}
