package com.conway;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CellContainer implements Iterable<Cell> {
    private List<Cell> cells;

    public CellContainer() {
        this.cells = new ArrayList<>();
    }

    public CellContainer(List<Cell> cells) {
        this.cells = cells;
    }

    public boolean contains(Cell cell) {
        return this.cells.contains(cell);
    }

    public void add(Cell cell) {
        if (!this.contains(cell)) {
            this.cells.add(cell);
        }
    }

    public int getSize() {
        return this.cells.size();
    }

    @Override
    public Iterator<Cell> iterator() {
        return this.cells.iterator();
    }
}
