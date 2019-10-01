public abstract class Enemies{
    public int health;
    public int attack;
    public String name;
    
    public Enemies(int attack, int health, String name){
        this.attack = attack;
        this.health = health;
        this.name = name;
    }

    public abstract int attack();
    public abstract int specialAttack();
    public abstract void reduceHealth(int dealtAttack);
    public abstract void increaseHealth(int healthIncrease);
    public abstract int getHealth();
}
