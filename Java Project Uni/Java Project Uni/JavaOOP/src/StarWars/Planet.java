package StarWars;

public class Planet extends Jedi {
    private final Jedi[] jedis;
    private int jediCount;

    public Planet(String planetName, int maxJedis) {
        this.jedis = new Jedi[maxJedis];
        this.jediCount = 0;
    }

    public boolean addJedi(Jedi j) {
        if (jediCount >= jedis.length) return false;
        jedis[jediCount++] = j;
        j.setPlanet(this);
        return true;
    }
}