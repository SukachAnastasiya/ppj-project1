package characters;

import elements.Apple;
import elements.Food;
import elements.Meat;
import map.Map;
import map.Shop;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Character {
    public boolean win;
    public ArrayList<Food> foodInventory = new ArrayList<>();
    public ArrayList<Weapon> weaponInventory = new ArrayList<>();
    private String name;
    public Map map;
    public Weapon weapon;
    public int money;
    public int x, y;
    public boolean magic;

    public Player(int point, Weapon weapon, String name, Map map) {
        super(point, 50, map);
        this.map = map;
        this.name = name;
        this.weapon = weapon;
        this.money = 15;
        this.win = false;
        this.magic = false;
    }

    public void setPosition(int x, int y) {
        this.map.setPosition(x, y, this.type);
        this.x = x;
        this.y = y;
    }

    public void getMagic() {
        System.out.println("Congratulations! You have magic power\n" +
                "All your attacks increase in twice");
        this.magic = true;
        if (this.weapon != null)
            this.weapon.attack *= 2;
        this.attack = 5;
    }

    public void storeWeapon(Weapon weapon) {
        if (this.weaponInventory.size() < 2) {
            System.out.println("Do you want to store this weapon? y/n");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if (choice.equals("y") || choice.equals("Y")) {
                this.weaponInventory.add(weapon);

            }
            if (choice.equals("n") || choice.equals("N")) {
                this.weapon = weapon;
            }
        }
    }


    public void changeWeapon() {
        if (this.weaponInventory.size() > 0) {
            System.out.println("Choose what you want to use\n" +
                    "0 return");
            for (int i = 0; i < this.weaponInventory.size(); i++)
                System.out.println(i + 1 + " " + this.weaponInventory.get(i).getClass().getSimpleName());
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.close();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    if (this.weaponInventory.get(0) != null) {
                        Weapon weapon = this.weapon;
                        this.weapon = this.weaponInventory.get(0);
                        this.weaponInventory.set(0, weapon);
                    }
                    break;
                case 2:
                    if (this.foodInventory.get(1) != null) {
                        Weapon weapon = this.weapon;
                        this.weapon = this.weaponInventory.get(1);
                        this.weaponInventory.set(1, weapon);
                    }
                    break;
            }
        }
    }


    public void storeFood(Food food) {
        if (this.health < 50) {
            System.out.println("You have " + this.health + " health\n" +
                    "Do you want to eat this food?  y/n");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if (choice.equals("y")) {
                this.eatFood(food);
            }
        }
        if (this.foodInventory.size() < 3) {
            System.out.println("Do you want to store this food?  y/n");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if (choice.equals("y") || choice.equals("Y")) {
                this.foodInventory.add(food);
            }
        }
    }

    public void eatFoodFromInventory() {
        if (this.foodInventory.size() > 0) {
            System.out.println("Choose what you want to eat\n" +
                    "0 exit");
            for (int i = 0; i < this.foodInventory.size(); i++)
                System.out.println(i + 1 + " " + this.foodInventory.get(i).getClass().getSimpleName());
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    if (this.foodInventory.get(0) != null) {
                        this.eatFood(this.foodInventory.get(0));
                        this.foodInventory.remove(0);
                    }
                    break;
                case 2:
                    if (this.foodInventory.get(1) != null) {
                        this.eatFood(this.foodInventory.get(1));
                        this.foodInventory.remove(1);
                    }
                    break;
                case 3:
                    if (this.foodInventory.get(2) != null) {
                        this.eatFood(this.foodInventory.get(2));
                        this.foodInventory.remove(2);
                    }
                    break;
            }
        }
    }

    public void eatFood(Food food) {
        if (this.health + food.health > 50)
            this.health = 50;
        else
            this.health += food.health;
    }

    public void getStatus() {
        System.out.println("you have\n" + this.point + " points\n" +
                this.health + " health\n" +
                this.attack + " your attack\n" +
                this.money + " money");
        if (this.weapon != null)
            this.weapon.getStatus();
        if (this.weaponInventory.size() > 0) {
            System.out.println("In weapon inventory");
            for (Weapon weapon : this.weaponInventory)
                weapon.getStatus();
        }
        if (this.foodInventory.size() > 0) {
            System.out.println("In food inventory");
            for (Food food : this.foodInventory)
                food.getStatus();
        }
        System.out.println();
    }

    public void attack(Character opponent) {
        if (weapon != null) {
            opponent.health -= this.weapon.attack;
            this.weapon.numberOfHits--;
        } else
            opponent.health -= this.attack;
        this.health -= opponent.attack;
    }

    public boolean fight(Character opponent) {
        if (this.weapon != null)
            this.weapon.hits(this);
        opponent.getStatus();
        boolean begin = false;
        while (!begin) {
            System.out.println("0 status\n" +
                    "1 if you want to change your weapon\n" +
                    "2: if you want to increase your health\n" +
                    "if something else, fight will start");
            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();
            if(option==1 || option==2 || option==0) {
                if (option == 0)
                    this.getStatus();
                if (option == 1) {
                    if (this.weapon != null)
                        this.weapon.getStatus();
                    if (this.weaponInventory.size() > 0)
                        this.changeWeapon();
                }
                if (option == 2) {
                    if (this.health == 50)
                        System.out.println("you have max health");
                    if (this.health < 50 && this.foodInventory.size() > 0)
                        this.eatFoodFromInventory();
                }
            }else
                begin=true;
        }
        this.attack(opponent);
        if (this.dead()) {
            return false;
        }
        if (opponent.dead()) {
            System.out.println("You win this fight!");
            return true;
        }
        System.out.println("next round");
        return this.fight(opponent);
    }

    public boolean meet(Character opponent) {
        System.out.println("you met a " + opponent.type);
        opponent.getStatus();
        System.out.println("Do you want to fight with it? y/n");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("y") || choice.equals("Y")) {
            boolean end = this.fight(opponent);
            if (opponent.type.equals("Wolf") && end)
                storeFood(new Meat());
            if (end && opponent.type.equals("Dragon"))
                this.win = true;

        } else
            return false;
        if (opponent.dead())
            return true;
        return false;
    }

    public void findMoney() {
        int amount = (int) (Math.random() * 10);
        System.out.println("Congratulations! You have found " + amount + " money");
        this.money += amount;
    }

    public void changePosition(int x, int y) {
        this.map.setPosition(this.x, this.y, null);
        this.map.setPosition(x, y, this.type);
        this.x = x;
        this.y = y;
    }

    public void chooseDirection() {
        boolean choose = false;
        while (!choose) {
            System.out.println("Input your direction:\n" +
                    "input 'q' to go up and left\n" +
                    "input 'e' to go up and right\n" +
                    "input 'a' to go left\n" +
                    "input 'd' to go right\n" +
                    "input 'z' to go down and left\n" +
                    "input 'c' to go down and right\n" +
                    "input 's' if you want to check your status");
            Scanner scanner = new Scanner(System.in);
            String direction = scanner.nextLine();
            if (direction.equals("s")) {
                this.getStatus();
            }
            if (direction.equals("q")) {
                if (this.x % 2 == 0)
                    this.move(this.x - 1, this.y);
                else
                    this.move(this.x - 1, this.y - 1);
                choose = true;
            }

            if (direction.equals("e")) {
                if (this.x % 2 == 0)
                    this.move(this.x - 1, this.y + 1);
                else
                    this.move(this.x - 1, this.y);
                choose = true;
            }

            if (direction.equals("a")) {
                this.move(this.x, this.y - 1);
                choose = true;
            }

            if (direction.equals("d")) {
                this.move(this.x, this.y + 1);
                choose = true;
            }

            if (direction.equals("z")) {
                if (this.x % 2 == 0)
                    this.move(this.x + 1, this.y);
                else
                    this.move(this.x + 1, this.y - 1);
                choose = true;
            }

            if (direction.equals("c")) {
                if (this.x % 2 == 0)
                    this.move(this.x + 1, this.y + 1);
                else
                    this.move(this.x + 1, this.y);
                choose = true;
            }
        }
    }

    public void move(int x, int y) {

        this.map.check(x, y);
        if (x == -1) {
            x = 1;
            this.x += 2;
        }

        if (y == -1) {
            y = 0;
            this.y = 0;
        }

        String tile = this.map.getCoordinates(x, y);

        if (tile == null) {
            this.changePosition(x, y);
        } else {
            if (tile.equals("Apple")) {
                this.storeFood(new Apple());
                this.changePosition(x, y);
            }
            if (tile.equals("Dragon")) {
                boolean survive = this.meet(new Dragon());
                if (survive)
                    this.win=true;
            }
            if (tile.equals("Wolf")) {
                boolean survive = this.meet(new Wolf());
                if (survive)
                    this.changePosition(x, y);
            }
            if (tile.equals("Shop")) {
                Shop shop = new Shop();
                shop.interactionWithShop(this);
                this.changePosition(x, y);
            }
            if (tile.equals("Money")) {
                this.findMoney();
                this.changePosition(x, y);
            }

            if (tile.equals("Magic")) {
                this.getMagic();
                this.changePosition(x, y);
            }
        }
    }

}
