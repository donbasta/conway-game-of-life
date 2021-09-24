package com.conway;

import com.conway.model.Board;
import com.conway.model.Cell;
import com.conway.model.CellContainer;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        try {
            CellContainer lifeCells = new CellContainer(new ArrayList<>(Arrays.asList(
                    new Cell(1, 2),
                    new Cell(1, 3),
                    new Cell(2, 3),
                    new Cell(2, 4),
                    new Cell(3, 3),
                    new Cell(3, 4)
            )));
            lifeCells.print();

            Board board = new Board(5, 5);
            board.setLifeCells(lifeCells);
            int life = 10;
            while (life --> 0) {
                board.show();
                board.nextTick();
            }
        } catch (Exception ignored) {
        }
    }
}
