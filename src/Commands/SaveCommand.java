package Commands;

import StarWars.ApplicationContext;

/**
 * Saves the currently opened file.
 */
public class SaveCommand implements Command {
    private ApplicationContext context;

    public SaveCommand(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        context.saveFile();
    }
}
