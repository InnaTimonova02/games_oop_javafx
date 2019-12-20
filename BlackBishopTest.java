package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;


public class BlackBishopTest {

    @Test
    public void whenPositionThenPositionDefined() {
        BishopBlack bishopBlack = new BishopBlack(Cell.E5);
        Cell cell = bishopBlack.position();
        assertThat(bishopBlack.position(), is(cell));
    }

    @Test
    public void whenCopyFigureThenSamePosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F6);
        bishopBlack.copy(Cell.F6);
        Cell cell = bishopBlack.position();
        assertThat(bishopBlack.position(), is(cell));
    }

    @Test
    public void whenMoveFigureThenFigureChangesPlace() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expect = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result, is(expect));
    }
}