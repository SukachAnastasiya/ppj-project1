package map;

import java.util.ArrayList;

public class Map {
    public int height, width;
    public ArrayList<ArrayList<String>> position = new ArrayList<>();
    private String[] element = {"Dragon", "Wolf", "Apple", "Shop", "Money", "Magic"};

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        for (int i = 0; i < height; i++) {
            ArrayList<String> line = new ArrayList<>();
            for (int j = 0; j < width; j++)
                line.add(null);
            position.add(line);
        }
    }

    public void check(int x, int y) {
        if (x < 0)
            increaseHeightUp();
        if (x >= this.height)
            increaseHeightDown();
        if (y < 0)
            increaseWidthLeft();
        if (y >= this.width)
            increaseWidthRight();
    }

    public void increaseHeightUp() {
        this.height++;
        for (int k = 0; k < 2; k++) {
            ArrayList<String> line = new ArrayList<>();
            for (int i = 0; i < width; i++) {
                line.add(null);
            }
            this.generateInLine(line);
            this.position.add(0, line);
        }
    }

    public void increaseHeightDown() {
        this.height++;
        ArrayList<String> line = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            line.add(null);
        }
        this.generateInLine(line);
        this.position.add(line);
    }

    public void increaseWidthRight() {
        this.width++;
        for (ArrayList<String> e : this.position) {
            String temp = "";
            temp = randomElement(temp);
            e.add(temp);
        }
    }

    public void increaseWidthLeft() {
        this.width++;
        for (ArrayList<String> e : this.position) {
            String temp = "";
            temp = randomElement(temp);
            e.add(0, temp);
        }
    }

    public void setPosition(int x, int y, String type) {
        this.position.get(x).set(y, type);
    }

    public String getCoordinates(int x, int y) {
        return this.position.get(x).get(y);
    }


    public void generateMap() {
        int[][] randGen = new int[this.height][this.width];
        randGen[randGen.length / 2][randGen.length / 2] = 1;
        for (int i = 0; i < element.length; i++) {
            int n = 5;
            if (i == 0)
                n = 3;
            if (i == element.length - 1)
                n = 1;
            for (int j = 0; j < n; j++) {
                boolean generated = false;
                while (!generated) {
                    int x = (int) (Math.random() * this.height);
                    int y = (int) (Math.random() * this.width);
                    if (randGen[x][y] == 0) {
                        randGen[x][y] = 1;
                        generated = true;
                        this.setPosition(x, y, element[i]);
                    }
                }
            }
        }
    }

    public void generateInLine(ArrayList<String> line) {
        int[] randGen = new int[line.size()];
        for (int i = 0; i < line.size() / 3; i++) {
            int el = (int) (Math.random() * element.length - 1);
            boolean generated = false;
            while (!generated) {
                int pos = (int) (Math.random() * line.size());
                if (randGen[pos] == 0) {
                    randGen[pos] = 1;
                    generated = true;
                    line.set(pos, element[el]);
                }
            }
        }
    }

    public String randomElement(String str) {
        int rand = (int) (1 + Math.random() * 10);
        if (rand > 5) {
            int randGen = (int) (Math.random() * element.length - 1);
            str = element[randGen];
        } else
            str = null;
        return str;
    }

    public void show() {
        System.out.println();
        for (int i = 0; i < this.position.size(); i++) {
            if (i % 2 == 0)
                System.out.print("    ");
            System.out.println(this.position.get(i));
        }
        System.out.println();
    }

}
