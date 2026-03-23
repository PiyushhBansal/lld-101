package com.example.pen;

public class ClickPen extends Pen {

    private boolean clicked;

    public ClickPen(Refill refill) {
        super(refill);
        this.clicked = false;
    }

    @Override
    public void start() {
        clicked = true;
        setOpen(true);
        System.out.println("clicked open");
    }

    @Override
    public void close() {
        clicked = false;
        setOpen(false);
        System.out.println("clicked close");
    }
}
