import characters.*;
import characters.Character;
import map.Map;

public class Start {
    public static void main(String[] args) {
        Map map = new Map();
        Character player = new Player(map, "Asya", null);
        System.out.println(map.position.get(5).get(5));
        player.setPosition(5,5, "P");
        player.getCoordinates();
    }
}
