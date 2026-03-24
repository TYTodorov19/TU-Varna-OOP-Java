package StarWars;

public class Universe {
    private Planet[] planets;
    private int planetCount;

    public Universe(int capacity) {
        this.planets = new Planet[capacity];
        this.planetCount = 0;
    }

    public boolean addPlanet(String name) {
        for (int i = 0; i < planetCount; i++) {
            if (planets[i].getName().equals(name)) {
                return false;
            }
        }
        planets[planetCount++] = new Planet(name, 100);
        return true;
    }

    private Planet findPlanet(String name) {
        for (int i = 0; i < planetCount; i++) {
            if (planets[i].getName().equals(name)) {
                return planets[i];
            }
        }
        return null;
    }

    private boolean jediExists(String name) {
        for (int i = 0; i < planetCount; i++) {
            Planet p = planets[i];
            for (int j = 0; j < p.getJediCount(); j++) {
                if (p.getJedis()[j].getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void createJedi(String planetName, String jediName, Rank rank,
                           int age, String color, double strength) {

        Planet planet = findPlanet(planetName);

        if (planet == null || jediExists(jediName)) {
            System.out.println("Failed to create Jedi.");
            return;
        }

        Jedi jedi = new Jedi(jediName, rank, age, color, strength);

        if (planet.addJedi(jedi)) {
            System.out.println("Jedi created successfully.");
        } else {
            System.out.println("Failed to create Jedi.");
        }
    }
}