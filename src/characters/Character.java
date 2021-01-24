package characters;

public abstract class Character {
    protected int health;
    protected int point;
    public int attack;
    protected int step;
    protected int money;

    public Character(){}

    public Character(int health, int point, int money, int attack, int step) {
        this.health = health;
        this.point = point;
        this.money = money;
        this.attack = attack;
        this.step = step;
    }
}
