package Commands;

import StarWars.Rank;
import StarWars.Universe;

/**
 * Prints the youngest Jedi with a given rank on a planet.
 */
public class GetYoungestJediCommand implements Command {
    private Universe universe;
    private String planetName;
    private Rank rank;

    public GetYoungestJediCommand(Universe universe, String planetName, Rank rank) {
        this.universe = universe;
        this.planetName = planetName;
        this.rank = rank;
    }

    @Override
    public void execute() {
        universe.getYoungestJedi(planetName, rank);
    }
}
