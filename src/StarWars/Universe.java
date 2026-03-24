package StarWars;

public class Universe {
    private Planet[] planets;
    private int planetCount;

    public Universe(int capacity) {
        this.planets = new Planet[capacity];
        this.planetCount = 0;
    }

    // Add planet
    public boolean addPlanet(String name) {
        for (int i = 0; i < planetCount; i++) {
            if (planets[i].getName().equals(name)) {
                return false;
            }
        }
        planets[planetCount++] = new Planet(name, 100);
        return true;
    }

    // Find planet by name
    private Planet findPlanet(String name) {
        for (int i = 0; i < planetCount; i++) {
            if (planets[i].getName().equals(name)) return planets[i];
        }
        return null;
    }

    // Check if a Jedi exists in universe
    private boolean jediExists(String name) {
        for (int i = 0; i < planetCount; i++) {
            Planet p = planets[i];
            for (int j = 0; j < p.getJediCount(); j++) {
                if (p.getJedis()[j].getName().equals(name)) return true;
            }
        }
        return false;
    }

    // Create Jedi
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

    // Promote Jedi
    public void promoteJedi(String jediName) {
        for (int i = 0; i < planetCount; i++) {
            Planet p = planets[i];
            for (int j = 0; j < p.getJediCount(); j++) {
                Jedi jedi = p.getJedis()[j];
                if (jedi.getName().equals(jediName)) {
                    Rank currentRank = jedi.getRank();
                    Rank[] ranks = Rank.values();
                    int nextIndex = currentRank.ordinal() + 1;
                    if (nextIndex < ranks.length) {
                        jedi.setRank(ranks[nextIndex]);
                        System.out.println(jediName + " promoted to " + ranks[nextIndex]);
                    } else {
                        System.out.println(jediName + " is already at highest rank.");
                    }
                    return;
                }
            }
        }
        System.out.println("Jedi " + jediName + " not found.");
    }
}