package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {
    private int size;
    List<ArrayList<String>> map = new ArrayList<ArrayList<String>>();


    public Map() {
        while (size < 20)
            size = (int) (Math.random() * 100);
        for (int i = 0; i <= size / 2; i++) {
            ArrayList<String> line = new ArrayList<>();
            for (int j = 0; j < size / 2 + i; j++)
                line.add(null);
            map.add(line);
        }
        for (int i = size / 2 + 1; i >= 0; i--)
            map.add(map.get(size - i));
    }

    public void setPosition(int x, int y) {
    }

    /*public void sketch(List map) {
        for (int i = 0; i < map.size(); i++) {

        }
    }*/

    public void kuda() {
        System.out.println("Input your way:");
        Scanner scanner = new Scanner(System.in);
        String way = scanner.nextLine();
        if (way.equals("we") || way.equals("e"))

    }

}
