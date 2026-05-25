import Commands.Command;
import Commands.CommandParser;
import StarWars.ApplicationContext;

import java.util.Scanner;

/**
 * Main class of the application.
 * It reads console input and executes command objects.
 */
public class Main {
    /**
     * Starts the application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApplicationContext context = new ApplicationContext();
        CommandParser parser = new CommandParser(context);

        while (true) {
            String line = scanner.nextLine();

            if (line.trim().isEmpty()) {
                continue;
            }

            Command command = parser.parse(line);
            command.execute();

            if (command.shouldExit()) {
                break;
            }
        }
    }
}
