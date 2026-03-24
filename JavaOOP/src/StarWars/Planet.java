package StarWars;

public class Planet {
    private String name;
    private Jedi[] jedis;
    private int jediCount;

    public Planet(String name, int capacity) {
        this.name = name;
        this.jedis = new Jedi[capacity];
        this.jediCount = 0;
    }

    public String getName() {
        return name;
    }

    public boolean addJedi(Jedi j) {
        if (jediCount >= jedis.length) return false;
        jedis[jediCount++] = j;
        j.setPlanet(this);
        return true;
    }

    public Jedi[] getJedis() {
        return jedis;
    }

    public int getJediCount() {
        return jediCount;
    }
}