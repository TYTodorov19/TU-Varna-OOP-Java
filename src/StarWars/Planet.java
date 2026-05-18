package StarWars;
/**
 * Represents a planet that contains a collection of Jedi.
 */
public class Planet {
    private String name;
    private Jedi[] jedis;
    private int jediCount;
    /**
     * Creates a planet with a given name.
     *
     * @param name the name of the planet
     */
    public Planet(String name, int capacity) {
        this.name = name;
        this.jedis = new Jedi[capacity];
        this.jediCount = 0;
    }

    public String getName() {
        return name;
    }

    public Jedi[] getJedis() {
        return jedis;
    }

    public int getJediCount() {
        return jediCount;
    }
    /**
     * Adds a Jedi to the planet.
     *
     * @param jedi the Jedi that will be added
     */
    public boolean addJedi(Jedi jedi) {
        if (jediCount >= jedis.length) {
            return false;
        }

        for (int i = 0; i < jediCount; i++) {
            if (jedis[i].getName().equals(jedi.getName())) {
                return false;
            }
        }

        jedis[jediCount++] = jedi;
        return true;
    }
    /**
     * Removes a Jedi from the planet by name.
     *
     * @param jediName the name of the Jedi
     * @return true if the Jedi is removed successfully, false otherwise
     */
    public boolean removeJedi(String jediName) {
        for (int i = 0; i < jediCount; i++) {
            if (jedis[i].getName().equals(jediName)) {
                for (int j = i; j < jediCount - 1; j++) {
                    jedis[j] = jedis[j + 1];
                }
                jedis[jediCount - 1] = null;
                jediCount--;
                return true;
            }
        }
        return false;
    }
}