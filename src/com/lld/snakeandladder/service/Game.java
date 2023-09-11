package com.lld.snakeandladder.service;

import com.lld.snakeandladder.model.*;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    private final Queue<Player> players;
    private final Board board;
    private final Dice dice;

    public Game(BoardInitializer boardInitializer) {
        this.players = new LinkedList<>();
        this.board = boardInitializer.getBoard();
        this.dice = new Dice(1, 1, 6);
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public Dice getDice() {
        return dice;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void play(){
        while(players.size() > 1){
            Player player = players.poll();
            int diceVal = dice.roll();
            int newPos = player.getPosition() + diceVal;
            if(newPos > board.getEnd()){
                players.add(player);
            }
            else{
                player.setPosition(getNewPosition(newPos, player.getId()));
                if(hasPlayerWon(player.getPosition())){
                    System.out.println("Player "+player.getId()+" has won");
                    player.setWon(true);
                }
                else{
                    System.out.println("Setting new position for player "+player.getId()+" as "+player.getPosition());
                    players.add(player);
                }
            }
        }
    }

    private int getNewPosition(int pos, String id){
        for(Snake snake : board.getSnakes()){
            if(snake.getStart() == pos){
                System.out.print("Snake for "+id+" ");
                System.out.println(snake.getEncounterMessage());
                return snake.getEnd();
            }
        }
        for(Ladder ladder : board.getLadders()){
            if(ladder.getStart() == pos){
                System.out.print("Ladder for "+id+" ");
                System.out.println(ladder.getEncounterMessage());
                return ladder.getEnd();
            }
        }
        return pos;
    }

    private boolean hasPlayerWon(int pos){
        return pos == board.getEnd();
    }
}
