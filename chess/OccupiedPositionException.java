package ru.job4j.chess;

public class OccupiedPositionException extends RuntimeException {
    public OccupiedPositionException(String rsn) {
        super(rsn);
    }
}
