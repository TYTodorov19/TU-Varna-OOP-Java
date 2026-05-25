package Commands;

import StarWars.ApplicationContext;
import StarWars.Rank;

/**
 * Converts user input into command objects.
 */
public class CommandParser {
    private ApplicationContext context;

    /**
     * Creates command parser with application context.
     *
     * @param context current application context
     */
    public CommandParser(ApplicationContext context) {
        this.context = context;
    }

    /**
     * Parses a console line and creates the correct command object.
     *
     * @param line user input
     * @return command object
     */
    public Command parse(String line) {
        line = line.trim();

        if (line.startsWith("open ")) {
            return new OpenCommand(context, line.substring(5).trim());
        }

        if (line.equals("close")) {
            return new CloseCommand(context);
        }

        if (line.equals("save")) {
            return new SaveCommand(context);
        }

        if (line.startsWith("save as ")) {
            String path = line.substring(8).trim();
            if (path.startsWith("\"") && path.endsWith("\"") && path.length() >= 2) {
                path = path.substring(1, path.length() - 1);
            }
            return new SaveAsCommand(context, path);
        }

        if (line.equals("help")) {
            return new HelpCommand();
        }

        if (line.equals("exit")) {
            return new ExitCommand();
        }

        if (!context.isFileOpened()) {
            return new NoFileOpenCommand();
        }

        try {
            if (line.contains(" + ")) {
                String[] planets = line.split("\\s+\\+\\s+");
                if (planets.length == 2) {
                    return new CombinedPlanetsCommand(context.getUniverse(), planets[0], planets[1]);
                }
                return new InvalidCommand();
            }

            String[] parts = line.split("\\s+");
            String command = parts[0];

            switch (command) {
                case "add_planet":
                    if (parts.length == 2) {
                        return new AddPlanetCommand(context.getUniverse(), parts[1]);
                    }
                    break;

                case "create_jedi":
                    if (parts.length == 7) {
                        return new CreateJediCommand(
                                context.getUniverse(),
                                parts[1],
                                parts[2],
                                Rank.valueOf(parts[3]),
                                Integer.parseInt(parts[4]),
                                parts[5],
                                Double.parseDouble(parts[6])
                        );
                    }
                    break;

                case "removeJedi":
                    if (parts.length == 3) {
                        return new RemoveJediCommand(context.getUniverse(), parts[1], parts[2]);
                    }
                    break;

                case "promote_jedi":
                    if (parts.length == 3) {
                        return new PromoteJediCommand(context.getUniverse(), parts[1], Double.parseDouble(parts[2]));
                    }
                    break;

                case "demote_jedi":
                    if (parts.length == 3) {
                        return new DemoteJediCommand(context.getUniverse(), parts[1], Double.parseDouble(parts[2]));
                    }
                    break;

                case "get_strongest_jedi":
                    if (parts.length == 2) {
                        return new GetStrongestJediCommand(context.getUniverse(), parts[1]);
                    }
                    break;

                case "get_youngest_jedi":
                    if (parts.length == 3) {
                        return new GetYoungestJediCommand(context.getUniverse(), parts[1], Rank.valueOf(parts[2]));
                    }
                    break;

                case "get_most_used_saber_color":
                    if (parts.length == 2) {
                        return new GetMostUsedSaberColorCommand(context.getUniverse(), parts[1]);
                    }
                    if (parts.length == 3) {
                        return new GetMostUsedSaberColorCommand(context.getUniverse(), parts[1], Rank.valueOf(parts[2]));
                    }
                    break;

                case "print":
                    if (parts.length == 2) {
                        return new PrintCommand(context.getUniverse(), parts[1]);
                    }
                    break;

                default:
                    break;
            }
        } catch (Exception e) {
            return new InvalidCommand();
        }

        return new InvalidCommand();
    }
}
