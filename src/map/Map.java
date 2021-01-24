package map;

import characters.Character;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private int size;
    public List<ArrayList<String>> position = new ArrayList<>();


    public Map() {
        this.size = 11;
        for (int i = 0; i <= size / 2; i++) {
            ArrayList<String> line = new ArrayList<>();
            for (int j = 0; j < size / 2 + i; j++)
                line.add(null);
            position.add(line);
        }
        for (int i = size / 2 + 1; i >= 0; i--)
            position.add(position.get(size - i));
    }

    public void setPosition(int coordinateX, int coordinateY, String element){
        this.position.get(coordinateX).set(coordinateY,element);
    }


    /*public void kuda() {
        System.out.println("Input your way:");
        Scanner scanner = new Scanner(System.in);
        String way = scanner.nextLine();
        if (way.equals("we") || way.equals("e"))

    }*/

}
