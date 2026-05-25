package Commands;

import StarWars.ApplicationContext;

/**
 * Closes the currently opened file.
 */
public class CloseCommand implements Command {
    private ApplicationContext context;

    public CloseCommand(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        context.closeFile();
    }
}
