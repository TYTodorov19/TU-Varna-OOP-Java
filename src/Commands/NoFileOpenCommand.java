package Commands;

/**
 * Command used when a Star Wars command is entered without opened file.
 */
public class NoFileOpenCommand implements Command {
    @Override
    public void execute() {
        System.out.println("No file is currently open.");
    }
}
