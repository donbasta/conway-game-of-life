package com.conway;

import java.util.List;

public class CellContainer {
    private List<Cell> cells;

    public CellContainer(List<Cell> cells) {
        this.cells = cells;
    }

    public boolean contains(Cell cell) {
        return this.cells.contains(cell);
    }

    public void add(Cell cell) {
    }

    public int getSize() {
        return this.cells.size();
    }
}
