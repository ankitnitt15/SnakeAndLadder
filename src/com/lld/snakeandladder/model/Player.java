package com.lld.snakeandladder.model;

public class Player {
    private String id;
    private int position;
    private boolean won;

    public Player(String id) {
        this.id = id;
        this.position = 0;
        this.won = false;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public String getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWon() {
        return won;
    }
}
