package StarWars;

public class Jedi {
    private String name;
    private Rank rank;
    private int age;
    private String saberColor;
    private double strength;
    private Planet planet;

    public Jedi(String name, Rank rank, int age, String saberColor, double strength) {
        this.name = name;
        this.rank = rank;
        this.age = age;
        this.saberColor = saberColor;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}