package StarWars;

/**
 * Represents a planet that contains a collection of Jedi.
 */
public class Planet {
    private String name;
    private JediCollection jediCollection;

    /**
     * Creates a planet with a given name and Jedi capacity.
     *
     * @param name the name of the planet
     * @param capacity maximum number of Jedi on the planet
     */
    public Planet(String name, int capacity) {
        this.name = name;
        this.jediCollection = new JediCollection(capacity);
    }

    /**
     * Returns planet name.
     *
     * @return planet name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the Jedi collection object.
     *
     * @return Jedi collection
     */
    public JediCollection getJediCollection() {
        return jediCollection;
    }

    /**
     * Returns Jedi array for file operations and printing.
     *
     * @return array of Jedi
     */
    public Jedi[] getJedis() {
        return jediCollection.getItems();
    }

    /**
     * Returns current number of Jedi.
     *
     * @return Jedi count
     */
    public int getJediCount() {
        return jediCollection.getCount();
    }

    /**
     * Adds a Jedi to the planet.
     *
     * @param jedi the Jedi that will be added
     * @return true if added successfully, false otherwise
     */
    public boolean addJedi(Jedi jedi) {
        return jediCollection.add(jedi);
    }

    /**
     * Removes a Jedi from the planet by name.
     *
     * @param jediName the name of the Jedi
     * @return true if removed successfully, false otherwise
     */
    public boolean removeJedi(String jediName) {
        return jediCollection.removeByName(jediName);
    }
}
