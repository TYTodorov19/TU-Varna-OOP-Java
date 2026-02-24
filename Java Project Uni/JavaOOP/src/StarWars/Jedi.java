package StarWars;

public class Jedi {
    String jediName;
    String[] rank = {"YOUNGLING", "INITIATE", "PADAWAN", "KNIGHT-ASPIRANT", "KNIGHT", "MASTER", "BATTLE_MASTER", "GRAND_MASTER"};
    int age;
    String swordColor;
    float strength;

    public Jedi(String jediName, String[] rank, int age, String swordColor, float strength) {
        this.jediName = jediName;
        this.rank = rank;
        this.age = age;
        this.swordColor = swordColor;
        this.strength = strength;
    }

    public String getJediName() {
        return jediName;
    }

    public void setJediName(String jediName) {
        this.jediName = jediName;
    }

    public String[] getRank() {
        return rank;
    }

    public void setRank(String[] rank) {
        this.rank = rank;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSwordColor() {
        return swordColor;
    }

    public void setSwordColor(String swordColor) {
        this.swordColor = swordColor;
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        if(strength >=1 && strength<=2) {
            this.strength = strength;
        }
        else{
            System.out.println("Invalid Strength");
        }
    }
}
