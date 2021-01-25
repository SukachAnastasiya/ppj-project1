package map;

import characters.Character;
import com.sun.xml.internal.stream.Entity;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private int width, height;
    public List<ArrayList<String>> position = new ArrayList<>();

    public Map() {
        this.width = 11;
        this.height = 11;
        for (int i = 0; i < height; i++) {
            ArrayList<String> line = new ArrayList<>();
            for (int j = 0; j < width; j++)
                line.add(null);
            position.add(line);
        }
    }

    public void setPosition(int coordinateX, int coordinateY, String element) {
        this.position.get(coordinateX).set(coordinateY, element);
    }

    public void changePosition(int x1, int y1, int x2, int y2, String type) {
        checkSize(x2,y2);
        position.get(x1).set(y1, null);
        setPosition(x2, y2, type);
    }

    public void checkSize(int x, int y) {
        if (x >= height)
            increaseSize("height+");
        if (x < height)
            increaseSize("+height");
        if (y >= width)
            increaseSize("width+");
        if (y < width)
            increaseSize("+width");
    }

    public void increaseSize(String direction) {
        switch (direction) {
            case ("height+"): {
                this.height++;
                ArrayList<String> line = new ArrayList<>();
                for (int i = 0; i < width; i++) {
                    line.add(null);
                }
                this.position.add(line);
            }
            break;

            case ("+height"): {
                this.height++;
                ArrayList<String> line = new ArrayList<>();
                for (int i = 0; i < width; i++) {
                    line.add(null);
                }
                this.position.add(0, line);
            }
            break;

            case ("width+"): {
                this.width++;
                for (ArrayList<String> e : this.position) {
                    e.add(null);
                }
            }
            break;

            case ("+width"): {
                this.width++;
                for (ArrayList<String> e : this.position) {
                    e.add(0, null);
                }
            }
            break;
        }

    }

}
