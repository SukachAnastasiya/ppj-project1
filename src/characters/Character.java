package characters;


import map.Map;

public abstract class Character{

    protected int health;
    protected int point;
    public int attack;
    protected int step;
    protected int money;
    protected int coordinateX;
    protected int coordinateY;
    protected Map map;

    public Character(){}

    public Character(Map map, int health, int point, int money, int attack, int step) {
        this.map=map;
        this.health = health;
        this.point = point;
        this.money = money;
        this.attack = attack;
        this.step = step;
    }

    public void setPosition(int coordinateX, int coordinateY, String element) {
        this.map.setPosition(coordinateX,coordinateY, element);
        this.coordinateX=coordinateX;
        this.coordinateY=coordinateY;
    }

    public void getCoordinates(){
        System.out.println("x: "+getCoordinateX()+"\ny: "+getCoordinateY());
    }

    public int getCoordinateX(){
        return this.coordinateX;
    }

    public int getCoordinateY(){
        return this.coordinateY;
    }

}
