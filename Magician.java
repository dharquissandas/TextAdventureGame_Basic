public class Magician extends Enemies implements Entity{

    private String name;
    private int health;
    private int attack;
    private String type;

    public Magician(String name, int health, int attack, String type){
        super(attack, health, name);
        this.type = type;
    }

    @Override
    public int attack(){
        return attack;
    }

    @Override
    public int specialAttack() {
        System.out.println(name + " used special attack");
        return attack*2;
    }

    @Override
    public void reduceHealth(int dealtAttack) {
        health =- dealtAttack;
    }

    @Override
    public void increaseHealth(int healthIncrease) {
        health =+ healthIncrease;
    }

    //Getters & Setters

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String getName() {
        return name;
    }
}
