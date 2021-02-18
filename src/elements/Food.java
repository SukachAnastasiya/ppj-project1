package elements;

public class Food {
    public int health;
    public String type;

    public Food(int health) {
        this.health = health;
        this.type = this.getClass().getSimpleName();
    }

    public void getStatus(){
        System.out.println(this.type+" can get you "+ this.health+" health");
    }
}
