package Commands;

import StarWars.Rank;
import StarWars.Universe;

/**
 * Creates a new Jedi on a planet.
 */
public class CreateJediCommand implements Command {
    private Universe universe;
    private String planetName;
    private String jediName;
    private Rank rank;
    private int age;
    private String saberColor;
    private double strength;

    public CreateJediCommand(Universe universe, String planetName, String jediName, Rank rank,
                             int age, String saberColor, double strength) {
        this.universe = universe;
        this.planetName = planetName;
        this.jediName = jediName;
        this.rank = rank;
        this.age = age;
        this.saberColor = saberColor;
        this.strength = strength;
    }

    @Override
    public void execute() {
        universe.createJedi(planetName, jediName, rank, age, saberColor, strength);
    }
}
