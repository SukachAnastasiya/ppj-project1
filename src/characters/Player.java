package characters;

import weapon.Weapon;

public class Player extends Character {
    private String name;
    private Weapon weapon;


    public Player(String name, Weapon weapon) {
        super(50, 0, 15, 7,1);
        this.name = name;
        this.weapon=weapon;
    }

    public void setOnMap(int coordinateX, int coordinateY){
        this.coordinateX=coordinateX;
        this.coordinateY=coordinateY;
    }
}
