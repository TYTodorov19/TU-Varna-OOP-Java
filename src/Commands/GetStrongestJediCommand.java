package Commands;

import StarWars.Universe;

/**
 * Prints the strongest Jedi on a planet.
 */
public class GetStrongestJediCommand implements Command {
    private Universe universe;
    private String planetName;

    public GetStrongestJediCommand(Universe universe, String planetName) {
        this.universe = universe;
        this.planetName = planetName;
    }

    @Override
    public void execute() {
        universe.getStrongestJedi(planetName);
    }
}
