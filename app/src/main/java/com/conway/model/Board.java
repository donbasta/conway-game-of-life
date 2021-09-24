package com.conway.model;

public class Board {
    private final int row, col;
    private CellContainer lifeCells;
    private static final int[] DIF_ROW = {-1, 0, 1};
    private static final int[] DIF_COL = {-1, 0, 1};

    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        lifeCells = new CellContainer();
    }

    public void setLifeCells(CellContainer cellContainer) {
        lifeCells = cellContainer;
    }

    public boolean isOutOfBound(int row, int col) {
        return row < 0 || col < 0 || row >= this.row || col >= this.col;
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
            return ((countLifeNeighbor == 2) || (countLifeNeighbor == 3));
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
                    if (liveOnTheNextTick(cell.getX() + r, cell.getY() + c)) {
                        temp.add(new Cell(cell.getX() + r, cell.getY() + c));
                    }
                }
            }
        }
        this.lifeCells = temp;
    }

    public void show() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (lifeCells.contains(new Cell(i, j))) {
                    System.out.print("😄");
                } else {
                    System.out.print("()");
                }
            }
            System.out.println();
        }
        System.out.println("-----------");
    }
}
