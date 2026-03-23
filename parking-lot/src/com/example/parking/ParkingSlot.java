package com.example.parking;

public class ParkingSlot {
    int slotNumber;
    SlotType slotType;
    int floor;
    int distance;
    boolean isOccupied;

    public ParkingSlot(int slotNumber, SlotType slotType, int floor, int distance) {
        this.slotNumber = slotNumber;
        this.slotType = slotType;
        this.floor = floor;
        this.distance = distance;
        this.isOccupied = false;
    }

    public int getSlotNumber() { return slotNumber; }
    public SlotType getSlotType() { return slotType; }
    public int getFloor() { return floor; }
    public int getDistance() { return distance; }
    public boolean isOccupied() { return isOccupied; }

    public void occupy() { this.isOccupied = true; }
    public void free() { this.isOccupied = false; }
}
