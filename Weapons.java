public abstract class Weapons{
    private String name;
    private int strength;

    public Weapons(String name, int strength) {
        this.setStrength(strength);
        this.setName(name);
    }
    
    public abstract void attack();


    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
