package Commands;

import StarWars.Rank;
import StarWars.Universe;

/**
 * Prints the most used saber color.
 */
public class GetMostUsedSaberColorCommand implements Command {
    private Universe universe;
    private String planetName;
    private Rank rank;
    private boolean useRank;

    public GetMostUsedSaberColorCommand(Universe universe, String planetName) {
        this.universe = universe;
        this.planetName = planetName;
        this.useRank = false;
    }

    public GetMostUsedSaberColorCommand(Universe universe, String planetName, Rank rank) {
        this.universe = universe;
        this.planetName = planetName;
        this.rank = rank;
        this.useRank = true;
    }

    @Override
    public void execute() {
        if (useRank) {
            universe.getMostUsedSaberColor(planetName, rank);
        } else {
            universe.getMostUsedSaberColor(planetName);
        }
    }
}
