package Commands;

/**
 * Exits the program.
 */
public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Exiting the program...");
    }

    @Override
    public boolean shouldExit() {
        return true;
    }
}
