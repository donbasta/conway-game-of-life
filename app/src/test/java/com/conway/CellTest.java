package com.conway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CellTest {

    @Test
    void whenDifferentXReturnNotEqual() {
        Cell cell1 = new Cell(1, 2);
        Cell cell2 = new Cell(2, 2);
        assertNotEquals(cell1, cell2);
    }

    @Test
    void whenDifferentYReturnNotEqual() {
        Cell cell1 = new Cell(1, 2);
        Cell cell2 = new Cell(1, 3);
        assertNotEquals(cell1, cell2);
    }
}
