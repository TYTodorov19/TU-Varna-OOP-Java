package Commands;

/**
 * Represents a console command.
 * Every concrete command has its own class and execute method.
 */
public interface Command {
    /**
     * Executes the command.
     */
    void execute();

    /**
     * Shows whether the program should stop after this command.
     *
     * @return true if the program should exit
     */
    default boolean shouldExit() {
        return false;
    }
}
