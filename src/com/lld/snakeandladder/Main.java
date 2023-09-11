package com.lld.snakeandladder;

import com.lld.snakeandladder.model.Player;
import com.lld.snakeandladder.service.BoardInitializer;
import com.lld.snakeandladder.service.Game;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter board size");
        int boardSize = sc.nextInt();

        System.out.println("Enter number of snakes");
        int numOfSnakes = sc.nextInt();

        System.out.println("Enter number of ladders");
        int numOfLadders = sc.nextInt();

        System.out.println("Enter number of players");
        int numOfPlayers = sc.nextInt();

        BoardInitializer b = new BoardInitializer(numOfSnakes, numOfLadders, boardSize);
        Game game = new Game(b);

        for(int i=0; i<numOfPlayers; i++){
            System.out.println("Enter player name");
            String name = sc.next();
            Player player = new Player(name);
            game.addPlayer(player);
        }
        game.play();
    }
}
