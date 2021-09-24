package com.conway;

public class Board {
    private final boolean[][] grid;

    public Board(int row, int col) {
        grid = new boolean[row][col];
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
                if (grid[newRow][newCol]) {
                    countLifeNeighbor++;
                }
            }
        }
        if (grid[row][col]) {
            return (countLifeNeighbor == 2) || (countLifeNeighbor == 3);
        }
        return (countLifeNeighbor == 3);
    }
}
