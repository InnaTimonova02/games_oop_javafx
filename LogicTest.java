package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.NoMoveException;
import ru.job4j.chess.OccupiedPositionException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void whenFigureCanMove() {
        BishopBlack bishopBlack = new BishopBlack(Cell.E3);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        boolean move = logic.move(Cell.E3, Cell.G5);
        assertThat(move, is(true));
    }

    @Test
    public void whenFigureCannotMove() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        try {
            assertThat(logic.move(Cell.D4, Cell.E4), is(true));
        } catch (NoMoveException nme) {
            nme.getMessage();
        }
    }

    @Test
    public void whenCellIsOccupiedByOtherFigure() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F2);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        try {
            assertThat(logic.move(Cell.F2, Cell.E3), is(true));
        } catch (OccupiedPositionException ope) {
            ope.getMessage();
        }
    }
}