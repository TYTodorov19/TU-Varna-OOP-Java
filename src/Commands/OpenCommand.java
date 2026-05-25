package Commands;

import StarWars.ApplicationContext;

/**
 * Opens a file.
 */
public class OpenCommand implements Command {
    private ApplicationContext context;
    private String path;

    public OpenCommand(ApplicationContext context, String path) {
        this.context = context;
        this.path = path;
    }

    @Override
    public void execute() {
        context.openFile(path);
    }
}
