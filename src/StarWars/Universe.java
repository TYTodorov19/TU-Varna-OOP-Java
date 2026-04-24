package StarWars;

public class Universe {
    private Planet[] planets;
    private int planetCount;

    public Universe(int capacity) {
        this.planets = new Planet[capacity];
        this.planetCount = 0;
    }

    public Planet[] getPlanets() {
        return planets;
    }

    public int getPlanetCount() {
        return planetCount;
    }

    public void clear() {
        this.planets = new Planet[100];
        this.planetCount = 0;
    }

    public boolean addPlanet(String name) {
        if (findPlanet(name) != null || planetCount >= planets.length) {
            return false;
        }
        planets[planetCount++] = new Planet(name, 100);
        return true;
    }

    public Planet findPlanet(String name) {
        for (int i = 0; i < planetCount; i++) {
            if (planets[i].getName().equals(name)) {
                return planets[i];
            }
        }
        return null;
    }

    public Jedi findJedi(String name) {
        for (int i = 0; i < planetCount; i++) {
            Planet p = planets[i];
            for (int j = 0; j < p.getJediCount(); j++) {
                if (p.getJedis()[j].getName().equals(name)) {
                    return p.getJedis()[j];
                }
            }
        }
        return null;
    }

    public Planet findJediPlanet(String jediName) {
        for (int i = 0; i < planetCount; i++) {
            Planet p = planets[i];
            for (int j = 0; j < p.getJediCount(); j++) {
                if (p.getJedis()[j].getName().equals(jediName)) {
                    return p;
                }
            }
        }
        return null;
    }

    private boolean jediExists(String name) {
        return findJedi(name) != null;
    }

    public void createJedi(String planetName, String jediName, Rank rank, int age, String color, double strength) {
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

    public void removeJedi(String jediName, String planetName) {
        Planet planet = findPlanet(planetName);
        if (planet == null) {
            System.out.println("Failed to remove Jedi.");
            return;
        }

        if (planet.removeJedi(jediName)) {
            System.out.println("Jedi removed successfully.");
        } else {
            System.out.println("Failed to remove Jedi.");
        }
    }

    public void promoteJedi(String jediName, double multiplier) {
        if (multiplier <= 0) {
            System.out.println("Invalid multiplier.");
            return;
        }

        Jedi jedi = findJedi(jediName);
        if (jedi == null) {
            System.out.println("Jedi not found.");
            return;
        }

        Rank[] ranks = Rank.values();
        int current = jedi.getRank().ordinal();
        if (current < ranks.length - 1) {
            jedi.setRank(ranks[current + 1]);
        }

        jedi.setStrength(jedi.getStrength() + multiplier * jedi.getStrength());
        System.out.println("Jedi promoted successfully.");
    }

    public void demoteJedi(String jediName, double multiplier) {
        if (multiplier <= 0) {
            System.out.println("Invalid multiplier.");
            return;
        }

        Jedi jedi = findJedi(jediName);
        if (jedi == null) {
            System.out.println("Jedi not found.");
            return;
        }

        int current = jedi.getRank().ordinal();
        if (current > 0) {
            jedi.setRank(Rank.values()[current - 1]);
        }

        jedi.setStrength(jedi.getStrength() - multiplier * jedi.getStrength());
        System.out.println("Jedi demoted successfully.");
    }

    public void getStrongestJedi(String planetName) {
        Planet planet = findPlanet(planetName);
        if (planet == null || planet.getJediCount() == 0) {
            System.out.println("No Jedi found.");
            return;
        }

        Jedi strongest = planet.getJedis()[0];
        for (int i = 1; i < planet.getJediCount(); i++) {
            if (planet.getJedis()[i].getStrength() > strongest.getStrength()) {
                strongest = planet.getJedis()[i];
            }
        }

        System.out.println(strongest);
    }

    public void getYoungestJedi(String planetName, Rank rank) {
        Planet planet = findPlanet(planetName);
        if (planet == null) {
            System.out.println("No such Jedi found.");
            return;
        }

        Jedi youngest = null;
        for (int i = 0; i < planet.getJediCount(); i++) {
            Jedi current = planet.getJedis()[i];
            if (current.getRank() == rank) {
                if (youngest == null ||
                        current.getAge() < youngest.getAge() ||
                        (current.getAge() == youngest.getAge() &&
                                current.getName().compareTo(youngest.getName()) < 0)) {
                    youngest = current;
                }
            }
        }

        if (youngest == null) {
            System.out.println("No such Jedi found.");
        } else {
            System.out.println(youngest);
        }
    }

    public void getMostUsedSaberColor(String planetName, Rank rank) {
        Planet planet = findPlanet(planetName);
        if (planet == null) {
            System.out.println("No such saber color found.");
            return;
        }

        String[] colors = new String[100];
        int[] counts = new int[100];
        int size = 0;

        for (int i = 0; i < planet.getJediCount(); i++) {
            Jedi jedi = planet.getJedis()[i];
            if (jedi.getRank() == rank) {
                String color = jedi.getSaberColor();
                int index = -1;

                for (int j = 0; j < size; j++) {
                    if (colors[j].equals(color)) {
                        index = j;
                        break;
                    }
                }

                if (index == -1) {
                    colors[size] = color;
                    counts[size] = 1;
                    size++;
                } else {
                    counts[index]++;
                }
            }
        }

        if (size == 0) {
            System.out.println("No such saber color found.");
            return;
        }

        int best = 0;
        for (int i = 1; i < size; i++) {
            if (counts[i] > counts[best]) {
                best = i;
            }
        }

        System.out.println(colors[best]);
    }

    public void getMostUsedSaberColor(String planetName) {
        Planet planet = findPlanet(planetName);
        if (planet == null) {
            System.out.println("No such saber color found.");
            return;
        }

        String[] colors = new String[100];
        int[] counts = new int[100];
        int size = 0;

        for (int i = 0; i < planet.getJediCount(); i++) {
            Jedi jedi = planet.getJedis()[i];
            if (jedi.getRank() == Rank.GRAND_MASTER) {
                String color = jedi.getSaberColor();
                int index = -1;

                for (int j = 0; j < size; j++) {
                    if (colors[j].equals(color)) {
                        index = j;
                        break;
                    }
                }

                if (index == -1) {
                    colors[size] = color;
                    counts[size] = 1;
                    size++;
                } else {
                    counts[index]++;
                }
            }
        }

        if (size == 0) {
            System.out.println("No such saber color found.");
            return;
        }

        int best = 0;
        for (int i = 1; i < size; i++) {
            if (counts[i] > counts[best]) {
                best = i;
            }
        }

        System.out.println(colors[best]);
    }

    public void printPlanet(String planetName) {
        Planet planet = findPlanet(planetName);
        if (planet == null) {
            System.out.println("Planet not found.");
            return;
        }

        Jedi[] sorted = new Jedi[planet.getJediCount()];
        for (int i = 0; i < planet.getJediCount(); i++) {
            sorted[i] = planet.getJedis()[i];
        }

        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[i].getRank().ordinal() > sorted[j].getRank().ordinal() ||
                        (sorted[i].getRank() == sorted[j].getRank() &&
                                sorted[i].getName().compareTo(sorted[j].getName()) > 0)) {
                    Jedi temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }

        System.out.println("Planet: " + planet.getName());
        for (Jedi jedi : sorted) {
            System.out.println(jedi);
        }
    }

    public void printJedi(String jediName) {
        Jedi jedi = findJedi(jediName);
        Planet planet = findJediPlanet(jediName);

        if (jedi == null || planet == null) {
            System.out.println("Jedi not found.");
            return;
        }

        System.out.println(jedi);
        System.out.println("Planet: " + planet.getName());
    }

    public void print(String name) {
        if (findPlanet(name) != null) {
            printPlanet(name);
        } else if (findJedi(name) != null) {
            printJedi(name);
        } else {
            System.out.println("No such planet or Jedi.");
        }
    }

    public void printCombinedPlanets(String planet1, String planet2) {
        Planet p1 = findPlanet(planet1);
        Planet p2 = findPlanet(planet2);

        if (p1 == null || p2 == null) {
            System.out.println("Planet not found.");
            return;
        }

        Jedi[] combined = new Jedi[p1.getJediCount() + p2.getJediCount()];
        int index = 0;

        for (int i = 0; i < p1.getJediCount(); i++) {
            combined[index++] = p1.getJedis()[i];
        }

        for (int i = 0; i < p2.getJediCount(); i++) {
            combined[index++] = p2.getJedis()[i];
        }

        for (int i = 0; i < combined.length - 1; i++) {
            for (int j = i + 1; j < combined.length; j++) {
                if (combined[i].getName().compareTo(combined[j].getName()) > 0) {
                    Jedi temp = combined[i];
                    combined[i] = combined[j];
                    combined[j] = temp;
                }
            }
        }

        for (Jedi jedi : combined) {
            System.out.println(jedi);
        }
    }
}