package com.conway;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class CellContainerTest {
    private CellContainer cellContainer = new CellContainer(Arrays.asList(
        new Cell(1, 2),
        new Cell(1, 3)
    ));

    @Test
    void whenCheckingNotExistingCellShouldReturnFalse() {
        assertFalse(cellContainer.contains(new Cell(2, 3)));
    }

    @Test
    void whenAddingExistingCellShouldRemainTheSame() {
        cellContainer.add(new Cell(1, 3));
        assertEquals(2, cellContainer.getSize());
    }
}
