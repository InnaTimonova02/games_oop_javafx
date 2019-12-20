package ru.job4j.chess;

public class NoMoveException extends RuntimeException {
    public NoMoveException(String rsn) {
        super(rsn);
    }
}
