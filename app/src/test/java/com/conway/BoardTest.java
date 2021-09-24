package com.conway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    @Test
    void whenOutOfBoundCellPositionShouldReturnTrue() {
        Board board = new Board(2, 3);
        assertTrue(board.isOutOfBound(2, 3));
    }
}
