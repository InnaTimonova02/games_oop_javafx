package ru.job4j.chess.firuges.black;

import ru.job4j.chess.NoMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author inna.timonova (ms.timonovai@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {

        int deltaX = source.x - dest.x;
        int deltaY = source.y - dest.y;
        int size = Math.abs(deltaX);

        if (Math.abs(deltaX) != Math.abs(deltaY)) {
            throw new NoMoveException(
                    String.format("Could not move by diagonal from %s to %s", source, dest));
        }

        Cell[] steps = new Cell[size];
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy((source.x + (deltaX < 0 ? 1 : -1) * (index + 1)), (source.y + (deltaY < 0 ? 1 : -1) * (index + 1)));
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
