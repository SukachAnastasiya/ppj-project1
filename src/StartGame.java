import map.Map;
import characters.Player;

import java.util.Scanner;

public class StartGame extends Menu {
    public boolean win;

    public StartGame() {
        this.win = false;
        this.begin();
    }

    public boolean gameOver(Player player) {
        if (player.dead) {
            this.win = false;
            return true;
        }
        if (player.win) {
            this.win = true;
            return true;
        }
        return false;
    }

    public void begin() {
        Map map = new Map(7, 7);
        System.out.println("Input your name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        map.generateMap();
        Player player = new Player(0, null, name, map);
        player.setPosition(map.height / 2, map.width / 2);
        while(!player.dead && !player.win){
            map.show();
            player.chooseDirection();
        }
        gameOver(player);
    }
}
