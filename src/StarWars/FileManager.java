package StarWars;

import java.io.*;

public class FileManager {

    public static Universe loadFromFile(String filePath) throws IOException {
        Universe universe = new Universe(100);
        File file = new File(filePath);

        if (!file.exists()) {
            file.createNewFile();
            return universe;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        Planet currentPlanet = null;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            if (line.startsWith("PLANET|")) {
                String[] parts = line.split("\\|");
                if (parts.length != 2) {
                    throw new IOException("Invalid file format.");
                }
                universe.addPlanet(parts[1]);
                currentPlanet = universe.findPlanet(parts[1]);
            } else if (line.startsWith("JEDI|")) {
                String[] parts = line.split("\\|");
                if (parts.length != 6 || currentPlanet == null) {
                    throw new IOException("Invalid file format.");
                }

                String name = parts[1];
                Rank rank = Rank.valueOf(parts[2]);
                int age = Integer.parseInt(parts[3]);
                String color = parts[4];
                double strength = Double.parseDouble(parts[5]);

                currentPlanet.addJedi(new Jedi(name, rank, age, color, strength));
            } else {
                throw new IOException("Invalid file format.");
            }
        }

        reader.close();
        return universe;
    }

    public static void saveToFile(Universe universe, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        for (int i = 0; i < universe.getPlanetCount(); i++) {
            Planet planet = universe.getPlanets()[i];
            writer.write("PLANET|" + planet.getName());
            writer.newLine();

            for (int j = 0; j < planet.getJediCount(); j++) {
                Jedi jedi = planet.getJedis()[j];
                writer.write("JEDI|" + jedi.getName() + "|" + jedi.getRank() + "|" +
                        jedi.getAge() + "|" + jedi.getSaberColor() + "|" + jedi.getStrength());
                writer.newLine();
            }
        }

        writer.close();
    }
}