package StarWars;

import java.io.IOException;

/**
 * Holds the current application state.
 * This class manages the opened file and the loaded universe.
 */
public class ApplicationContext {
    private Universe universe;
    private String currentFilePath;
    private boolean fileOpened;

    /**
     * Creates empty application context.
     */
    public ApplicationContext() {
        this.universe = null;
        this.currentFilePath = null;
        this.fileOpened = false;
    }

    /**
     * Opens a file and loads universe data.
     *
     * @param path path to the file
     */
    public void openFile(String path) {
        try {
            universe = FileManager.loadFromFile(path);
            currentFilePath = path;
            fileOpened = true;
            System.out.println("Successfully opened " + extractFileName(path));
        } catch (IOException e) {
            System.out.println("Error opening file.");
        }
    }

    /**
     * Closes the current file and clears loaded data.
     */
    public void closeFile() {
        if (!fileOpened) {
            System.out.println("No file is currently open.");
            return;
        }

        System.out.println("Successfully closed " + extractFileName(currentFilePath));
        universe = null;
        currentFilePath = null;
        fileOpened = false;
    }

    /**
     * Saves data to the currently opened file.
     */
    public void saveFile() {
        if (!fileOpened) {
            System.out.println("No file is currently open.");
            return;
        }

        try {
            FileManager.saveToFile(universe, currentFilePath);
            System.out.println("Successfully saved " + extractFileName(currentFilePath));
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    /**
     * Saves data to another file.
     *
     * @param path path to the new file
     */
    public void saveAsFile(String path) {
        if (!fileOpened) {
            System.out.println("No file is currently open.");
            return;
        }

        try {
            FileManager.saveToFile(universe, path);
            System.out.println("Successfully saved " + extractFileName(path));
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    /**
     * Returns loaded universe.
     *
     * @return universe object
     */
    public Universe getUniverse() {
        return universe;
    }

    /**
     * Checks if a file is currently opened.
     *
     * @return true if file is opened
     */
    public boolean isFileOpened() {
        return fileOpened;
    }

    private String extractFileName(String path) {
        int idx1 = path.lastIndexOf('\\');
        int idx2 = path.lastIndexOf('/');
        int idx = Math.max(idx1, idx2);
        return idx == -1 ? path : path.substring(idx + 1);
    }
}
