import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Coordinate {
    public int a;
    public int b;
    public Coordinate() {}
    public Coordinate(int _a, int _b) {
        this.a = _a;
        this.b = _b;
    }
    public Coordinate add(Coordinate c) {
        Coordinate ret = new Coordinate();
        ret.a = this.a + c.a;
        ret.b = this.b + c.b;
        return ret;
    }
    public boolean equals(Coordinate c) {
        return (this.a == c.a) && (this.b == c.b);
    }
}

class LifeCells {
    public List<Coordinate> container;
    public LifeCells() {
        this.container = new ArrayList<>();
    }
    public LifeCells(List<Coordinate> _lifeCells) {
        this.container = _lifeCells;
    }
    public boolean contains(Coordinate c) {
        for (Coordinate coor : this.container) {
            if (coor.equals(c)) {
                return true;
            }
        }
        return false;
    }
}

public class Board {
    public static List<Coordinate> directions = new ArrayList<>(Arrays.asList(
        new Coordinate(0, 1),
        new Coordinate(1, 1),
        new Coordinate(1, 0),
        new Coordinate(1, -1),
        new Coordinate(0, -1),
        new Coordinate(-1, -1),
        new Coordinate(-1, 0),
        new Coordinate(-1, 1)
    ));

    public LifeCells lifeCells;
    public int tick = 0;

    public Board() {
        this.lifeCells = new LifeCells();
        this.tick = 0;
    }

    public Board(LifeCells _lifeCells) {
        this.lifeCells = _lifeCells;
        this.tick = 0;
    }

    public int countLifeNeighbors(Coordinate coordinate) {
        int lifeNeighbors = 0;
        for (Coordinate direction : Board.directions) {
            Coordinate neighbor = coordinate.add(direction);
            if (this.lifeCells.contains(neighbor)) {
                lifeNeighbors++;
            }
        }
        return lifeNeighbors;
    }

    public void nextTick() {
        List<Coordinate> temp = new ArrayList<>();

        for (Coordinate coord : this.lifeCells.container) {
            int lifeNeighbors = this.countLifeNeighbors(coord);
            if ((lifeNeighbors == 2) || (lifeNeighbors == 3)) {
                temp.add(coord);
            }
        }

        for (Coordinate coord : this.lifeCells.container) {
            for (Coordinate dir : Board.directions) {
                Coordinate cur = coord.add(dir);
                if (this.lifeCells.contains(cur)) {
                    continue;
                }
                int lifeNeighbors = this.countLifeNeighbors(cur);
                if ((lifeNeighbors == 2) || (lifeNeighbors == 3)) {
                    if (!temp.contains(coord)) {
                        temp.add(coord);
                    }
                }
            }
        }

        this.lifeCells = new LifeCells(temp);
    }

    public int getMaxX() {
        int ret = -1000000000;
        for (Coordinate c : this.lifeCells.container) {
            ret = Math.max(ret, c.a);
        }
        return ret;
    }
    public int getMaxY() {
        int ret = -1000000000;
        for (Coordinate c : this.lifeCells.container) {
            ret = Math.max(ret, c.b);
        }
        return ret;
    }
    public int getMinX() {
        int ret = 1000000000;
        for (Coordinate c : this.lifeCells.container) {
            ret = Math.min(ret, c.a);
        }
        return ret;
    }
    public int getMinY() {
        int ret = 1000000000;
        for (Coordinate c : this.lifeCells.container) {
            ret = Math.min(ret, c.b);
        }
        return ret;
    }
    
    public void show() {
        //todo
        int maxX = this.getMaxX();
        int maxY = this.getMaxY();
        int minX = this.getMinX();
        int minY = this.getMinY();
        int width = maxX - minX + 1;
        int height = maxY - minY + 1;
        // System.out.printf("%d %d\n", width, height);
        List<List<Boolean>> grid = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<Boolean> temp = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                temp.add(false);
            }
            grid.add(temp);
        }
        for (Coordinate c : this.lifeCells.container) {
            int pa = c.a - minX;
            int pb = c.b - minY;
            // System.out.printf("%d %d\n", pa, pb);
            grid.get(pb).set(pa, true);
        }
        for (int i = 0; i < height; i++) {
            List<Boolean> cur = grid.get(i);
            String ANSI_BG_RED    = "\u001B[41m";
            String ANSI_RESET  = "\u001B[0m";
            for (int j = 0; j < width; j++) {
                if (cur.get(j).equals(true)) {
                    System.out.print(ANSI_BG_RED + "   ");
                } else {
                    System.out.print("   ");
                }
                System.out.print(ANSI_RESET);
            }
            System.out.println("");
        }
        System.out.println("-----------------\n");
    }
}