package com.example.snl;

import java.util.*;

public class Board {

    private int size;
    private HashMap<Integer, Integer> snakeMap;
    private HashMap<Integer, Integer> ladderMap;

    public Board(int n, DifficultyLevel level) {
        this.size = n * n;
        this.snakeMap = new HashMap<>();
        this.ladderMap = new HashMap<>();
        placeSnakesAndLadders(n, level);
    }

    private void placeSnakesAndLadders(int n, DifficultyLevel level) {
        Random rand = new Random();
        HashSet<Integer> used = new HashSet<>();
        used.add(1);
        used.add(size);

        for (int i = 0; i < n; i++) {
            int head;
            do {
                head = rand.nextInt(size - 2) + 2;
            } while (used.contains(head));
            used.add(head);

            int tail;
            if (level == DifficultyLevel.HARD) {
                tail = rand.nextInt(Math.max(1, head / 2)) + 1;
            } else {
                tail = head - rand.nextInt(Math.max(1, head / 3)) - 1;
                if (tail < 1) tail = 1;
            }
            if (used.contains(tail)) tail = Math.max(1, tail - 1);
            used.add(tail);

            snakeMap.put(head, tail);
        }

        for (int i = 0; i < n; i++) {
            int start;
            do {
                start = rand.nextInt(size - 2) + 2;
            } while (used.contains(start));
            used.add(start);

            int end;
            if (level == DifficultyLevel.EASY) {
                end = start + rand.nextInt(size - start);
                if (end >= size) end = size - 1;
            } else {
                end = start + rand.nextInt(Math.max(1, (size - start) / 2)) + 1;
                if (end >= size) end = size - 1;
            }
            if (used.contains(end)) end = Math.min(size - 1, end + 1);
            used.add(end);

            ladderMap.put(start, end);
        }
    }

    public int getSize() {
        return size;
    }

    public int check(int pos) {
        if (snakeMap.containsKey(pos)) {
            int newPos = snakeMap.get(pos);
            System.out.println("  snake! " + pos + " -> " + newPos);
            return newPos;
        }
        if (ladderMap.containsKey(pos)) {
            int newPos = ladderMap.get(pos);
            System.out.println("  ladder! " + pos + " -> " + newPos);
            return newPos;
        }
        return pos;
    }

    public void printInfo() {
        System.out.println("Snakes: " + snakeMap);
        System.out.println("Ladders: " + ladderMap);
    }
}
