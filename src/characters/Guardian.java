package characters;

import weapon.Weapon;

public class Guardian extends Character {
    private int money;
    private Weapon weapon;

    public Guardian(Weapon weapon) {
        super(25, (int)(Math.random()*25), 5, 9,3);
        this.weapon = weapon;
    }
}
