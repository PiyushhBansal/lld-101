package com.example.pen;

public class Refill {

    private String color;
    private double inkLevel;

    public Refill(String color) {
        this.color = color;
        this.inkLevel = 1.0;
    }

    public String getColor() {
        return color;
    }

    public double getInkLevel() {
        return inkLevel;
    }

    public void useInk(double amount) {
        this.inkLevel = Math.max(0, this.inkLevel - amount);
    }

    public boolean isEmpty() {
        return inkLevel <= 0;
    }
}
