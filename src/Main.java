import StarWars.*;

import java.io.IOException;
import java.util.Scanner;

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

    private static void printHelp() {
        System.out.println("The following commands are supported:");
        System.out.println("open <file> opens <file>");
        System.out.println("close closes currently opened file");
        System.out.println("save saves the currently open file");
        System.out.println("save as <file> saves the currently open file in <file>");
        System.out.println("help prints this information");
        System.out.println("exit exits the program");
    }

    private static String extractFileName(String path) {
        int idx1 = path.lastIndexOf('\\');
        int idx2 = path.lastIndexOf('/');
        int idx = Math.max(idx1, idx2);
        return idx == -1 ? path : path.substring(idx + 1);
    }
}