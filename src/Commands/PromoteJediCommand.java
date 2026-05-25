package Commands;

import StarWars.Universe;

/**
 * Promotes a Jedi and increases strength.
 */
public class PromoteJediCommand implements Command {
    private Universe universe;
    private String jediName;
    private double multiplier;

    public PromoteJediCommand(Universe universe, String jediName, double multiplier) {
        this.universe = universe;
        this.jediName = jediName;
        this.multiplier = multiplier;
    }

    @Override
    public void execute() {
        universe.promoteJedi(jediName, multiplier);
    }
}
