package map;

import elements.Apple;
import elements.Food;
import elements.Meat;
import weapons.Axe;
import weapons.Sword;
import weapons.Weapon;
import characters.Player;


import java.util.Scanner;

public class Shop {

    public Food buyFood(Player player) {
        boolean choice = false;
        while (!choice) {
            System.out.println("You have " + player.money+" money\n"+
                    "What food do you want to buy?\n" +
                    "1 apple costs 3 money get 5 health\n" +
                    "2 meat costs 7 money get 15 health\n" +
                    "3 if you want to see your status\n" +
                    "4 if you want to return");
            Scanner scanner = new Scanner(System.in);
            int myChoice = scanner.nextInt();
            switch (myChoice) {
                case 1: {
                    player.money -= 3;
                    return new Apple();
                }
                case 2: {
                    player.money -= 7;
                    return new Meat();
                }
                case 3: {
                    player.getStatus();
                    break;
                }
                case 4:
                    return null;
            }
            System.out.println("Input another number");
        }
        return null;
    }

    public Weapon buyWeapon(Player player) {
        boolean choice = false;
        while (!choice) {
            System.out.println("You have " + player.money+" money\n"+
                    "What weapon do you want to buy?\n" +
                    "1 axe costs 5 money has 5 attack and 3 hits\n" +
                    "2 sword costs 10 money has 10 attack and 5 hits\n" +
                    "3 if you want to see your status\n" +
                    "4 if you don't want to return\n");
            Scanner scanner = new Scanner(System.in);
            int myChoice = scanner.nextInt();
            switch (myChoice) {
                case 1: {
                    player.money -= 5;
                    return new Axe(player);
                }
                case 2: {
                    player.money -= 10;
                    return new Sword(player);
                }
                case 3: {
                    player.getStatus();
                }
                case 4:
                    return null;
            }
            System.out.println("Input another number");
        }
        return null;
    }

    public void interactionWithShop(Player player) {
        boolean choice = false;
        while (!choice) {
            System.out.println("You have " + player.money+" money\n"+
                    "What do you want to buy?\n" +
                    "1 food\n" +
                    "2 weapon\n" +
                    "3 if you want to see your status\n" +
                    "4 if nothing needed");
            Scanner scanner = new Scanner(System.in);
            int myCase = scanner.nextInt();
            switch (myCase) {
                case 1: {
                    Food food;
                    food = this.buyFood(player);
                    if (food != null) {
                        player.storeFood(food);
                    }
                    choice=true;
                    break;
                }
                case 2: {
                    Weapon weapon;
                    weapon = this.buyWeapon(player);
                    if (weapon != null) {
                        player.storeWeapon(weapon);
                    }
                    choice=true;
                    break;
                }
                case 3: {
                    player.getStatus();
                    break;
                }
                case 4:
                    return;
            }
        }
    }

}
