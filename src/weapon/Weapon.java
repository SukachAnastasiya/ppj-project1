package weapon;

public abstract class Weapon {
    protected int attack;
    protected int amount;

    public Weapon(int attack, int amount){
        this.attack=attack;
        this.amount=amount;
    }
}
