package Commands;

import StarWars.Universe;

/**
 * Prints information about a planet or Jedi.
 */
public class PrintCommand implements Command {
    private Universe universe;
    private String name;

    public PrintCommand(Universe universe, String name) {
        this.universe = universe;
        this.name = name;
    }

    @Override
    public void execute() {
        universe.print(name);
    }
}
