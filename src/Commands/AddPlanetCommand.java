package Commands;

import StarWars.Universe;

/**
 * Adds a new planet to the universe.
 */
public class AddPlanetCommand implements Command {
    private Universe universe;
    private String planetName;

    public AddPlanetCommand(Universe universe, String planetName) {
        this.universe = universe;
        this.planetName = planetName;
    }

    @Override
    public void execute() {
        if (universe.addPlanet(planetName)) {
            System.out.println("Planet added successfully.");
        } else {
            System.out.println("Failed to add planet.");
        }
    }
}
