package com.example.snl;

import java.util.*;

public class Game {

    private Board board;
    private Dice dice;
    private List<Player> players;
    private int totalPlayers;

    public Game(int n, int numPlayers, DifficultyLevel level) {
        this.board = new Board(n, level);
        this.dice = new Dice();
        this.players = new ArrayList<>();
        this.totalPlayers = numPlayers;

        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player("Player" + i));
        }
    }

    public void start() {
        System.out.println("Board: " + board.getSize() + " cells | " + totalPlayers + " players");
        board.printInfo();
        System.out.println();

        int playersLeft = players.size();
        int rank = 1;

        while (playersLeft > 1) {
            for (int i = 0; i < players.size(); i++) {
                Player p = players.get(i);
                if (p.hasWon()) continue;

                int dice = this.dice.roll();
                int oldPos = p.getPosition();
                int newPos = oldPos + dice;

                if (newPos > board.getSize()) {
                    System.out.println(p.getName() + " rolled " + dice + " -> cant move, stays at " + oldPos);
                    continue;
                }

                if (newPos == board.getSize()) {
                    p.setPosition(newPos);
                    p.setWon(true);
                    playersLeft--;
                    System.out.println(p.getName() + " rolled " + dice + " -> reached " + newPos + " | rank " + rank);
                    rank++;
                    if (playersLeft <= 1) break;
                    continue;
                }

                newPos = board.check(newPos);
                p.setPosition(newPos);
                System.out.println(p.getName() + " rolled " + dice + " -> " + newPos);
            }
            System.out.println();
        }

        System.out.println("game over");
    }
}
