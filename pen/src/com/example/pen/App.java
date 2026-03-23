package com.example.pen;

public class App {

    public static void main(String[] args) {

        Pen capPen = new CapPen(new Refill("Blue"));

        System.out.println("--- cap pen ---");
        capPen.write("Hello");
        capPen.start();
        capPen.write("Hello World");
        capPen.close();

        capPen.refill(new Refill("Red"));
        capPen.start();
        capPen.write("red text");
        capPen.close();

        System.out.println("\n--- click pen ---");
        Pen clickPen = new ClickPen(new Refill("Black"));
        clickPen.start();
        clickPen.write("click pen writing");
        clickPen.close();

        clickPen.refill(new Refill("Green"));
        clickPen.start();
        clickPen.write("green text");
        clickPen.close();
    }
}
