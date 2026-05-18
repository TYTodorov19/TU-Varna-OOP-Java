package StarWars;
/**
 * Represents a Jedi with name, rank, age, saber color and strength.
 */
public class Jedi {
    private String name;
    private Rank rank;
    private int age;
    private String saberColor;
    private double strength;

    /**
     * Creates a Jedi object.
     *
     * @param name the name of the Jedi
     * @param rank the rank of the Jedi
     * @param age the age of the Jedi
     * @param saberColor the color of the Jedi's lightsaber
     * @param strength the strength of the Jedi
     */

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

    public Rank getRank() {
        return rank;
    }

    public int getAge() {
        return age;
    }

    public String getSaberColor() {
        return saberColor;
    }

    public double getStrength() {
        return strength;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }
    /**
     * Returns text representation of the Jedi.
     *
     * @return formatted Jedi information
     */
    @Override
    public String toString() {
        return "Jedi{name='" + name + "', rank=" + rank + ", age=" + age +
                ", saberColor='" + saberColor + "', strength=" + strength + "}";
    }
}