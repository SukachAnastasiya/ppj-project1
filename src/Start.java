import characters.*;
import characters.Character;
import map.Map;

public class Start {
    public static void main(String[] args) {
        Map map = new Map();
        Character player = new Player(map, "Asya", null, "P");
        player.setPosition(5,10, "P");
        player.getCoordinates();
        player.direction();
        player.getCoordinates();
        System.out.println(map.position.get(5).get(11));
    }
}
