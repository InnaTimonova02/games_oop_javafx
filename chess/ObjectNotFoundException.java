package ru.job4j.chess;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String rsn) {
        super(rsn);
    }
}
