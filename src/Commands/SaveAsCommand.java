package Commands;

import StarWars.ApplicationContext;

/**
 * Saves data to another file.
 */
public class SaveAsCommand implements Command {
    private ApplicationContext context;
    private String path;

    public SaveAsCommand(ApplicationContext context, String path) {
        this.context = context;
        this.path = path;
    }

    @Override
    public void execute() {
        context.saveAsFile(path);
    }
}
