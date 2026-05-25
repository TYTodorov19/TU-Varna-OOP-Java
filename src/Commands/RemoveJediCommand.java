package Commands;

import StarWars.Universe;

/**
 * Removes a Jedi from a planet.
 */
public class RemoveJediCommand implements Command {
    private Universe universe;
    private String jediName;
    private String planetName;

    public RemoveJediCommand(Universe universe, String jediName, String planetName) {
        this.universe = universe;
        this.jediName = jediName;
        this.planetName = planetName;
    }

    @Override
    public void execute() {
        universe.removeJedi(jediName, planetName);
    }
}
