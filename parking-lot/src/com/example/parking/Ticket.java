package com.example.parking;

import java.time.LocalDateTime;

public class Ticket {
    String ticketId;
    Vehicle vehicle;
    ParkingSlot slot;
    LocalDateTime entryTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSlot slot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = LocalDateTime.now();
    }

    public String getTicketId() { return ticketId; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSlot getSlot() { return slot; }
    public LocalDateTime getEntryTime() { return entryTime; }

    public void printTicket() {
        System.out.println(ticketId + " | " + vehicle.getNumberPlate() + " | Slot " + slot.getSlotNumber() + " (" + slot.getSlotType() + ") | Floor " + slot.getFloor());
    }
}
