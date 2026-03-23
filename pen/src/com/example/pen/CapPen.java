package com.example.pen;

public class CapPen extends Pen {

    private boolean capOn;

    public CapPen(Refill refill) {
        super(refill);
        this.capOn = true;
    }

    @Override
    public void start() {
        capOn = false;
        setOpen(true);
        System.out.println("cap removed");
    }

    @Override
    public void close() {
        capOn = true;
        setOpen(false);
        System.out.println("cap on");
    }
}
