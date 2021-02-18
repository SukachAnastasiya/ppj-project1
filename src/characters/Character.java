package characters;

import map.Map;

public class Character {
    public Map map;
    public int point;
    public int health;
    public String type;
    protected int attack;
    public boolean dead;


    public Character(int point, int health, Map map) {
        this.map = map;
        this.point = point;
        this.health = health;
        this.type = this.getClass().getSimpleName();
        this.attack = 1;
        this.dead = false;
    }

    public Character(int attack, int point, int health) {
        this.attack = attack;
        this.point = point;
        this.health = health;
        this.type = this.getClass().getSimpleName();
    }

    public boolean dead() {
        if (this.health < 0) {
            this.dead = true;
            return true;
        }
        return false;
    }

    public void getStatus() {
        System.out.println(this.type + " has\n" +
                this.attack + " attacks\n" +
                this.health + " health\n" +
                this.point + " points");
    }

}
