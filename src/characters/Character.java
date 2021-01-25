package characters;


import map.Map;

import java.util.Scanner;

public abstract class Character {

    protected int health;
    protected int point;
    public int attack;
    protected int step;
    protected int money;
    protected int coordinateX;
    protected int coordinateY;
    public String type;
    protected Map map;

    public Character(Map map, int health, int point, int money, int attack, int step, String type) {
        this.map = map;
        this.health = health;
        this.point = point;
        this.money = money;
        this.attack = attack;
        this.step = step;
        this.type = type;
    }

    public void setPosition(int coordinateX, int coordinateY, String element) {
        this.map.setPosition(coordinateX, coordinateY, element);
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public abstract void direction();

    public void changePosition(int x, int y) {
        this.map.changePosition(this.coordinateX, this.coordinateY, x, y, this.type);
        this.coordinateX=x;
        this.coordinateY=y;
    }

    public void getCoordinates() {
        System.out.println("x: " + getCoordinateX() + "\ny: " + getCoordinateY());
    }

    public int getCoordinateX() {
        return this.coordinateX;
    }

    public int getCoordinateY() {
        return this.coordinateY;
    }

}
