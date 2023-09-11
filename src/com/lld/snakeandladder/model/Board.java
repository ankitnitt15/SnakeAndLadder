package com.lld.snakeandladder.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int start;
    private int end;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board(int size) {
        this.start = 1;
        this.end = size;
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
    }

    public void addSnake(Snake snake){
        snakes.add(snake);
    }

    public void addLadder(Ladder ladder){
        ladders.add(ladder);
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }
}
