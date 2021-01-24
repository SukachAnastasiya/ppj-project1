package characters;

import map.Map;
import weapon.Weapon;

public class Player extends Character {
    private String name;
    private Weapon weapon;



    public Player(Map map, String name, Weapon weapon) {
        super(map, 50, 0, 15, 7, 1);
        this.name = name;
        this.weapon = weapon;
    }

    public void setPosition(int coordinateX, int coordinateY, String element){
        super.setPosition(coordinateX, coordinateX, element);
    }

    /*public void setPosition(Map map, int coordinateX, int coordinateY) {
        super.setPosition(map, coordinateX, coordinateY);
        map.position.get(coordinateX).set(coordinateY, "P");
    }*/
}
