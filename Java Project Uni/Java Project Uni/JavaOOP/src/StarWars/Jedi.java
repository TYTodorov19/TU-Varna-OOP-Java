package StarWars;

public class Jedi {
   private String jediName;
   private Rank rank;
   private int age;
   private String saberColor;
   private float strength;
   private Planet planet;

    public Jedi(String jediName, Rank rank, int age, String saberColor, float strength, Planet planet) {
        this.jediName = jediName;
        this.rank = rank;
        this.age = age;
        this.saberColor = saberColor;
        this.strength = strength;
        this.planet = planet;
    }

    public Jedi() {
    }

    public String getJediName() {
        return jediName;
    }

    public void setJediName(String jediName) {
        this.jediName = jediName;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSaberColor() {
        return saberColor;
    }

    public void setSaberColor(String saberColor) {
        this.saberColor = saberColor;
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = (strength >= 1 && strength <= 2) ? strength : 1;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

}
