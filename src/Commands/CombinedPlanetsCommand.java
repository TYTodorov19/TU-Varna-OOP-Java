package Commands;

import StarWars.Universe;

/**
 * Prints combined information from two planets.
 */
public class CombinedPlanetsCommand implements Command {
    private Universe universe;
    private String firstPlanet;
    private String secondPlanet;

    public CombinedPlanetsCommand(Universe universe, String firstPlanet, String secondPlanet) {
        this.universe = universe;
        this.firstPlanet = firstPlanet;
        this.secondPlanet = secondPlanet;
    }

    @Override
    public void execute() {
        universe.printCombinedPlanets(firstPlanet, secondPlanet);
    }
}
