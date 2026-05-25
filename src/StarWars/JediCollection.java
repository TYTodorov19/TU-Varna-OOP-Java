package StarWars;

/**
 * Represents a collection of Jedi objects.
 * This class hides the internal array and provides methods for working with Jedi.
 */
public class JediCollection {
    private Jedi[] jedis;
    private int count;

    /**
     * Creates a Jedi collection with fixed capacity.
     *
     * @param capacity maximum number of Jedi in the collection
     */
    public JediCollection(int capacity) {
        this.jedis = new Jedi[capacity];
        this.count = 0;
    }

    /**
     * Adds a Jedi to the collection if there is free space and the name is unique.
     *
     * @param jedi the Jedi that will be added
     * @return true if the Jedi is added successfully, false otherwise
     */
    public boolean add(Jedi jedi) {
        if (count >= jedis.length || findByName(jedi.getName()) != null) {
            return false;
        }

        jedis[count++] = jedi;
        return true;
    }

    /**
     * Removes a Jedi by name.
     *
     * @param jediName the name of the Jedi
     * @return true if the Jedi is removed successfully, false otherwise
     */
    public boolean removeByName(String jediName) {
        for (int i = 0; i < count; i++) {
            if (jedis[i].getName().equals(jediName)) {
                for (int j = i; j < count - 1; j++) {
                    jedis[j] = jedis[j + 1];
                }
                jedis[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    /**
     * Finds a Jedi by name.
     *
     * @param name the name of the Jedi
     * @return the found Jedi or null
     */
    public Jedi findByName(String name) {
        for (int i = 0; i < count; i++) {
            if (jedis[i].getName().equals(name)) {
                return jedis[i];
            }
        }
        return null;
    }

    /**
     * Returns the internal array.
     *
     * @return array of Jedi
     */
    public Jedi[] getItems() {
        return jedis;
    }

    /**
     * Returns current number of Jedi.
     *
     * @return Jedi count
     */
    public int getCount() {
        return count;
    }
}
