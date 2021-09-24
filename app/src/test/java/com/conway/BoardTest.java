package com.conway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BoardTest {

    @Test
    void whenOutOfBoundCellPositionShouldReturnTrue() {
        Board board = new Board(2, 3);
        assertTrue(board.isOutOfBound(2, 3));
    }

    @Test
    void whenAllNeighborNotOutOfBoundShouldReturnCorrectNextState() {
        Board board = new Board(3, 3);
        assertFalse(board.liveOnTheNextTick(1, 1));
    }
}
