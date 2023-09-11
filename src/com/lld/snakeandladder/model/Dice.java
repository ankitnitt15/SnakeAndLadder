package com.lld.snakeandladder.model;


import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int diceCount;
    private int minValue;
    private int maxValue;

    public Dice(int diceCount, int minValue, int maxValue) {
        this.diceCount = diceCount;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
     public int roll(){
        int totalSum = 0;
        for(int i=0; i<diceCount; i++){
            totalSum += ThreadLocalRandom.current().nextInt(minValue, maxValue+1);
        }
        return totalSum;
     }
}
