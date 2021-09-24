package com.conway;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class CellContainerTest {

    @Test
    void whenCheckingNotExistingCellShouldReturnFalse() {
        CellContainer cellContainer = new CellContainer(Arrays.asList(
            new Cell(1, 2),
            new Cell(1, 3)
        ));
        assertFalse(cellContainer.contains(new Cell(2, 3)));
    }
}
