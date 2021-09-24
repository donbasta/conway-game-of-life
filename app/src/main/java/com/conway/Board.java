package com.conway;

public class Board {
    private final boolean[][] grid;
    private CellContainer lifeCells;
    private static final int[] DIF_ROW = {-1, 0, 1};
    private static final int[] DIF_COL = {-1, 0, 1};

    public Board(int row, int col) {
        grid = new boolean[row][col];
        lifeCells = new CellContainer();
    }

    public boolean isOutOfBound(int row, int col) {
        return row < 0 || col < 0 || row >= grid.length || col >= grid[0].length;
    }

    public boolean liveOnTheNextTick(int row, int col) {
        int countLifeNeighbor = 0;
        for (int r : DIF_ROW) {
            for (int c : DIF_COL) {
                if (r == 0 && c == 0) {
                    continue;
                }
                int newRow = row + r;
                int newCol = col + c;
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
            for (int r : DIF_ROW) {
                for (int c : DIF_COL) {
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
