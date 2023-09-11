package com.lld.snakeandladder.service;

import com.lld.snakeandladder.model.Board;
import com.lld.snakeandladder.model.Ladder;
import com.lld.snakeandladder.model.Snake;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class BoardInitializer {
    private int numberOfSnakes;
    private int numberOfLadders;
    private int boardSize;
    private Board board;

    public BoardInitializer(int numberOfSnakes, int numberOfLadders, int boardSize) {
        this.numberOfSnakes = numberOfSnakes;
        this.numberOfLadders = numberOfLadders;
        this.boardSize = boardSize;
        board = new Board(boardSize);
        initBoard();
    }

    private void initBoard() {
        Set<Integer> usedPositions = new HashSet<>();
        generateSnakes(usedPositions);
        generateLadders(usedPositions);
    }

    private void generateSnakes(Set<Integer> usedPositions) {
        for(int i=0; i<numberOfSnakes; i++){
            while(true){
                int start = generateRandom(board.getStart(), board.getEnd());
                int end = generateRandom(board.getStart(), board.getEnd());
                if(end >= start){
                    continue;
                }
                if(!usedPositions.contains(start)){
                    Snake snake = new Snake(start, end);
                    board.addSnake(snake);
                    usedPositions.add(start);
                    usedPositions.add(end);
                    break;
                }
            }
        }
    }

    private void generateLadders(Set<Integer> usedPositions) {
        for(int i=0; i<numberOfLadders; i++){
            while(true){
                int start = generateRandom(board.getStart(), board.getEnd());
                int end = generateRandom(board.getStart(), board.getEnd());
                if(end <= start){
                    continue;
                }
                if(!usedPositions.contains(start)){
                    Ladder ladder = new Ladder(start, end);
                    board.addLadder(ladder);
                    usedPositions.add(start);
                    break;
                }
            }
        }
    }

    private int generateRandom(int start, int end){
        return ThreadLocalRandom.current().nextInt(start, end+1);
    }

    public Board getBoard() {
        return board;
    }
}
