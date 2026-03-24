public class Main {
    public static void main(String[] args) {

        Universe universe = new Universe(100);

        universe.addPlanet("Tatooine");

        universe.createJedi(
                "Tatooine",
                "Luke",
                Rank.PADAWAN,
                20,
                "blue",
                1.5
        );
    }
}