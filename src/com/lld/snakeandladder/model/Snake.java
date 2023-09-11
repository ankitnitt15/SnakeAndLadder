package com.lld.snakeandladder.model;

public class Snake extends BoardEntity{
    public Snake(int start, int end){
        super(start, end);
    }

    @Override
    public String getEncounterMessage() {
        return "Sorry you got bit";
    }


}
