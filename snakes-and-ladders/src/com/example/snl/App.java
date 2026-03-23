package com.example.snl;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n (board will be nxn): ");
        int n = sc.nextInt();

        System.out.print("Number of players: ");
        int players = sc.nextInt();

        System.out.print("Difficulty (easy/hard): ");
        String d = sc.next();
        DifficultyLevel lvl = d.equalsIgnoreCase("hard") ? DifficultyLevel.HARD : DifficultyLevel.EASY;

        Game game = new Game(n, players, lvl);
        game.start();

        sc.close();
    }
}
