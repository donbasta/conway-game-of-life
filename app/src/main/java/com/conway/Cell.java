package com.conway;

import java.util.Objects;

public class Cell {
    private final int x;

    public Cell(int x, int y) {
        this.x = x;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Cell otherCell = (Cell) object;
        return x == otherCell.getX();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }

    public int getX() {
        return x;
    }
}
