package com.lld.snakeandladder.model;

public class Ladder extends BoardEntity{
    public Ladder(int start, int end){
        super(start, end);
    }

    @Override
    public String getEncounterMessage() {
        return "Congrats!! You will rise";
    }
}
