package StarWars;

public class Jedi {
    private String name;
    private Rank rank;
    private int age;
    private String saberColor;
    private double strength;

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

    @Override
    public String toString() {
        return "Jedi{name='" + name + "', rank=" + rank + ", age=" + age +
                ", saberColor='" + saberColor + "', strength=" + strength + "}";
    }
}