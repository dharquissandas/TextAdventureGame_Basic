public class Sword extends Weapons implements Entity {
    private String name;
    private int strength;

    public Sword(int strength, String name) {
        super(name, strength);
    }

    @Override
    public void attack() {

    }

    @Override
    public String getName() {
        return super.getName();
    }
}
