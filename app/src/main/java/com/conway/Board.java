package com.conway;

public class Board {
    private final boolean[][] grid;
    private CellContainer lifeCells;

    public Board(int row, int col) {
        grid = new boolean[row][col];
        lifeCells = new CellContainer();
    }

    public boolean isOutOfBound(int row, int col) {
        return row < 0 || col < 0 || row >= grid.length || col >= grid[0].length;
    }

    public boolean liveOnTheNextTick(int row, int col) {
        int[] difRow = {-1, 0, 1};
        int[] difCol = {-1, 0, 1};
        int countLifeNeighbor = 0;
        for (int r : difRow) {
            for (int c : difCol) {
                if (r == 0 && c == 0) {
                    continue;
                }
                int newRow = row + r;
                int newCol = col + c;
                if (isOutOfBound(newRow, newCol)) {
                    continue;
                }
                if (lifeCells.contains(new Cell(newRow, newCol))) {
                    countLifeNeighbor++;
                }
            }
        }
        if (lifeCells.contains(new Cell(row, col))) {
            return (countLifeNeighbor == 2) || (countLifeNeighbor == 3);
        }
        return (countLifeNeighbor == 3);
    }

    public CellContainer getLifeCells() {
        return this.lifeCells;
    }

    public void nextTick() {
        CellContainer temp = new CellContainer();

        for (Cell cell : this.lifeCells) {
            if (liveOnTheNextTick(cell.getX(), cell.getY())) {
                temp.add(cell);
            }
        }

        for (Cell cell : this.lifeCells) {
            int[] difRow = {-1, 0, 1};
            int[] difCol = {-1, 0, 1};
            for (int r : difRow) {
                for (int c : difCol) {
                    if (r == 0 && c == 0) {
                        continue;
                    }
                    int newRow = cell.getX() + r;
                    int newCol = cell.getY() + c;
                    if (liveOnTheNextTick(newRow, newCol)) {
                        temp.add(cell);
                    }
                }
            }
        }

        this.lifeCells = temp;
    }
}
