package Commands;

/**
 * Command used when the user enters invalid input.
 */
public class InvalidCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Invalid command.");
    }
}
