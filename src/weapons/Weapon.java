package weapons;

import characters.Player;

public class Weapon {
    public int attack;
    public int numberOfHits;

    public Weapon(int attack, int numberOfHits, Player player) {
        if (player.magic)
            this.attack = attack * 2;
        else
            this.attack = attack;
        this.numberOfHits = numberOfHits;
    }

    public void hits(Player player) {
        if (player.weapon.numberOfHits == 0)
            player.weapon = null;
    }

    public void getStatus() {
        System.out.println("Your weapon is " + this.getClass().getSimpleName() +
                "\nit can get " + this.attack + " points of life\n" +
                "and you can use it " + this.numberOfHits + " more time");
    }
}
