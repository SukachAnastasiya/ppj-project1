package characters;

import map.Map;
import weapon.Weapon;

import java.util.Scanner;

public class Player extends Character {
    private String name;
    private Weapon weapon;

    public Player(Map map, String name, Weapon weapon, String type) {
        super(map, 50, 0, 15, 7, 1, type);
        this.name = name;
        this.weapon = weapon;
    }

    public void setPosition(int coordinateX, int coordinateY, String element) {
        super.setPosition(coordinateX, coordinateX, element);
    }

    public void direction() {
        System.out.println("Input your direction:\n" +
                "input 'wq' or 'qq' to go up and left\n" +
                "input 'we' or 'ee' to go up and right\n" +
                "input 'aa' to go left\n" +
                "input 'dd' to go right\n" +
                "input 'xz' or 'zz' to go down and left\n" +
                "input 'xc' or 'cc' to go down and right");
        Scanner scanner = new Scanner(System.in);
        String direction = scanner.nextLine();
        boolean choice = true;
        while (choice) {
            if (direction.equals("wq") || direction.equals("qq")) {
                super.changePosition(this.coordinateX - 1, this.coordinateY - 1);
                choice = false;
            }
            if (direction.equals("we") || direction.equals("ee")) {
                super.changePosition(coordinateX - 1, coordinateY);
                choice = false;
            }
            if (direction.equals("dd")) {
                super.changePosition(this.coordinateX, this.coordinateY + 1);
                choice = false;
            }
            if (direction.equals("aa")) {
                super.changePosition(coordinateX, coordinateY - 1);
                choice = false;
            }
            if (direction.equals("xz") || direction.equals("zz")) {
                super.changePosition(coordinateX + 1, coordinateY);
                choice = false;
            }
            if (direction.equals("xc") || direction.equals("cc")) {
                super.changePosition(coordinateX + 1, coordinateY + 1);
                choice = false;
            }
            else if(choice)
                System.out.println("Input another direction");
        }
    }
}
