package com.example.pen;

public abstract class Pen {

    private Refill refill;
    private boolean isOpen;

    public Pen(Refill refill) {
        this.refill = refill;
        this.isOpen = false;
    }

    public void write(String text) {
        if (!isOpen) {
            System.out.println("pen not open");
            return;
        }
        if (refill == null || refill.isEmpty()) {
            System.out.println("no ink");
            return;
        }
        System.out.println("writing '" + text + "' in " + refill.getColor());
        refill.useInk(0.1);
    }

    public abstract void start();

    public abstract void close();

    public void refill(Refill newRefill) {
        this.refill = newRefill;
        System.out.println("refilled with " + newRefill.getColor());
    }

    public Refill getRefill() {
        return refill;
    }

    protected void setOpen(boolean open) {
        this.isOpen = open;
    }

    protected boolean isOpen() {
        return isOpen;
    }
}
