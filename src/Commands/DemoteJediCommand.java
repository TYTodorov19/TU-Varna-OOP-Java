package Commands;

import StarWars.Universe;

/**
 * Demotes a Jedi and decreases strength.
 */
public class DemoteJediCommand implements Command {
    private Universe universe;
    private String jediName;
    private double multiplier;

    public DemoteJediCommand(Universe universe, String jediName, double multiplier) {
        this.universe = universe;
        this.jediName = jediName;
        this.multiplier = multiplier;
    }

    @Override
    public void execute() {
        universe.demoteJedi(jediName, multiplier);
    }
}
