import StarWars.*;
/**
 * Main class of the application.
 * Reads commands from the console and executes them.
 */
import java.io.IOException;
import java.util.Scanner;
/**
 * Starts the program and reads user commands.
 *
 * @param args command line arguments
 */
public class Main {
    private static Universe universe = null;
    private static String currentFilePath = null;
    private static boolean fileOpened = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();

            if (line.trim().isEmpty()) {
                continue;
            }

            try {
                if (line.startsWith("open ")) {
                    String path = line.substring(5).trim();
                    openFile(path);
                    continue;
                }

                if (line.equals("close")) {
                    closeFile();
                    continue;
                }

                if (line.equals("save")) {
                    saveFile();
                    continue;
                }

                if (line.startsWith("save as ")) {
                    String path = line.substring(8).trim();
                    if (path.startsWith("\"") && path.endsWith("\"") && path.length() >= 2) {
                        path = path.substring(1, path.length() - 1);
                    }
                    saveAsFile(path);
                    continue;
                }

                if (line.equals("help")) {
                    printHelp();
                    continue;
                }

                if (line.equals("exit")) {
                    System.out.println("Exiting the program...");
                    break;
                }

                if (!fileOpened) {
                    System.out.println("No file is currently open.");
                    continue;
                }

                if (line.contains(" + ")) {
                    String[] parts = line.split("\\s+\\+\\s+");
                    if (parts.length == 2) {
                        universe.printCombinedPlanets(parts[0], parts[1]);
                    } else {
                        System.out.println("Invalid command.");
                    }
                    continue;
                }

                String[] parts = line.split("\\s+");
                String command = parts[0];

                switch (command) {
                    case "add_planet":
                        if (parts.length != 2) {
                            System.out.println("Invalid command.");
                        } else if (universe.addPlanet(parts[1])) {
                            System.out.println("Planet added successfully.");
                        } else {
                            System.out.println("Failed to add planet.");
                        }
                        break;

                    case "create_jedi":
                        if (parts.length != 7) {
                            System.out.println("Invalid command.");
                        } else {
                            universe.createJedi(
                                    parts[1],
                                    parts[2],
                                    Rank.valueOf(parts[3]),
                                    Integer.parseInt(parts[4]),
                                    parts[5],
                                    Double.parseDouble(parts[6])
                            );
                        }
                        break;

                    case "removeJedi":
                        if (parts.length != 3) {
                            System.out.println("Invalid command.");
                        } else {
                            universe.removeJedi(parts[1], parts[2]);
                        }
                        break;

                    case "promote_jedi":
                        if (parts.length != 3) {
                            System.out.println("Invalid command.");
                        } else {
                            universe.promoteJedi(parts[1], Double.parseDouble(parts[2]));
                        }
                        break;

                    case "demote_jedi":
                        if (parts.length != 3) {
                            System.out.println("Invalid command.");
                        } else {
                            universe.demoteJedi(parts[1], Double.parseDouble(parts[2]));
                        }
                        break;

                    case "get_strongest_jedi":
                        if (parts.length != 2) {
                            System.out.println("Invalid command.");
                        } else {
                            universe.getStrongestJedi(parts[1]);
                        }
                        break;

                    case "get_youngest_jedi":
                        if (parts.length != 3) {
                            System.out.println("Invalid command.");
                        } else {
                            universe.getYoungestJedi(parts[1], Rank.valueOf(parts[2]));
                        }
                        break;

                    case "get_most_used_saber_color":
                        if (parts.length == 2) {
                            universe.getMostUsedSaberColor(parts[1]);
                        } else if (parts.length == 3) {
                            universe.getMostUsedSaberColor(parts[1], Rank.valueOf(parts[2]));
                        } else {
                            System.out.println("Invalid command.");
                        }
                        break;

                    case "print":
                        if (parts.length != 2) {
                            System.out.println("Invalid command.");
                        } else {
                            universe.print(parts[1]);
                        }
                        break;

                    default:
                        System.out.println("Invalid command.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    /**
     * Opens a file and loads its data into memory.
     *
     * @param path the path to the file
     */
    private static void openFile(String path) {
        try {
            universe = FileManager.loadFromFile(path);
            currentFilePath = path;
            fileOpened = true;
            System.out.println("Successfully opened " + extractFileName(path));
        } catch (IOException e) {
            System.out.println("Error opening file.");
            System.exit(0);
        }
    }
    /**
     * Closes the currently opened file and clears loaded data.
     */
    private static void closeFile() {
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
     * Saves the current data to the opened file.
     */
    private static void saveFile() {
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
     * Saves the current data to another file.
     *
     * @param path the path to the new file
     */
    private static void saveAsFile(String path) {
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
     * Prints all supported commands.
     */
    private static void printHelp() {
        System.out.println("The following commands are supported:");

        System.out.println("open <file> - opens <file>");
        System.out.println("close - closes currently opened file");
        System.out.println("save - saves the currently open file");
        System.out.println("save as <file> - saves the currently open file in <file>");
        System.out.println("help - prints this information");
        System.out.println("exit - exits the program");

        System.out.println("add_planet <planet_name> - adds new planet");

        System.out.println("create_jedi <planet_name> <jedi_name> <jedi_rank> <jedi_age> <saber_color> <jedi_strength> - creates new jedi");

        System.out.println("removeJedi <jedi_name> <planet_name> - removes jedi from planet");

        System.out.println("promote_jedi <jedi_name> <multiplier> - promotes jedi with one rank and increases strength");

        System.out.println("demote_jedi <jedi_name> <multiplier> - demotes jedi with one rank and decreases strength");

        System.out.println("get_strongest_jedi <planet_name> - prints strongest jedi on planet");

        System.out.println("get_youngest_jedi <planet_name> <jedi_rank> - prints youngest jedi with given rank on planet");

        System.out.println("get_most_used_saber_color <planet_name> <jedi_rank> - prints most used saber color for rank on planet");

        System.out.println("get_most_used_saber_color <planet_name> - prints most used saber color by GRAND_MASTER jedis on planet");

        System.out.println("print <planet_name> - prints planet and its jedis");

        System.out.println("print <jedi_name> - prints jedi information");

        System.out.println("<planet_name> + <planet_name> - prints jedis from both planets sorted lexicographically");
    }

    /**
     * Extracts file name from a full file path.
     *
     * @param path the full file path
     * @return only the file name
     */
    private static String extractFileName(String path) {
        int idx1 = path.lastIndexOf('\\');
        int idx2 = path.lastIndexOf('/');
        int idx = Math.max(idx1, idx2);
        return idx == -1 ? path : path.substring(idx + 1);
    }
}