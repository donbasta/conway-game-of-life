package com.conway.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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

    @Test
    void whenNoLivingCellNextTickShouldContainsNoLivingCell() {
        Board board = new Board(1, 1);
        board.nextTick();
        int finalCountLivingCells = board.getLifeCells().getSize();
        assertEquals(0, finalCountLivingCells);
    }

    @Test
    void whenSquareShouldRemainTheSame() {
        Board board = new Board(5, 5);
        board.getLifeCells().add(new Cell(1, 1));
        board.getLifeCells().add(new Cell(1, 2));
        board.getLifeCells().add(new Cell(2, 1));
        board.getLifeCells().add(new Cell(2, 2));

        board.nextTick();

        assertEquals(4, board.getLifeCells().getSize());
    }
}
