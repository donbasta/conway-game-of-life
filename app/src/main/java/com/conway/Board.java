package com.conway;

public class Board {
    private final boolean[][] grid;

    public Board(int row, int col) {
        grid = new boolean[row][col];
    }

    public boolean isOutOfBound(int row, int col) {
        return row < 0 || col < 0 || row >= grid.length || col >= grid[0].length;
    }
}
