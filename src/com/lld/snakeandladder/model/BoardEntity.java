package com.lld.snakeandladder.model;

public abstract class BoardEntity {
    private int start;
    private int end;

    public BoardEntity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public abstract String getEncounterMessage();

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
