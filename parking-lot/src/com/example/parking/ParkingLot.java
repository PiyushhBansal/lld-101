package com.example.parking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot {

    private ArrayList<ParkingSlot> slots;
    private HashMap<String, Ticket> tickets;
    private HashMap<SlotType, Double> rates;
    private int counter = 0;

    public ParkingLot() {
        slots = new ArrayList<>();
        tickets = new HashMap<>();
        rates = new HashMap<>();
        rates.put(SlotType.SMALL, 10.0);
        rates.put(SlotType.MEDIUM, 20.0);
        rates.put(SlotType.LARGE, 30.0);
    }

    public void addSlot(ParkingSlot slot) {
        slots.add(slot);
    }

    private boolean canFit(VehicleType v, SlotType s) {
        if (v == VehicleType.TWO_WHEELER) return true;
        if (v == VehicleType.CAR && (s == SlotType.MEDIUM || s == SlotType.LARGE)) return true;
        if (v == VehicleType.BUS && s == SlotType.LARGE) return true;
        return false;
    }

    public Ticket park(Vehicle vehicle, LocalDateTime entryTime, SlotType requestedType, int entryGateId) {
        ParkingSlot best = null;
        int bestDist = 99999;

        for (int i = 0; i < slots.size(); i++) {
            ParkingSlot s = slots.get(i);
            if (s.isOccupied()) continue;
            if (!canFit(vehicle.getType(), s.getSlotType())) continue;

            int d = Math.abs(s.getDistance() - entryGateId);
            if (d < bestDist) {
                bestDist = d;
                best = s;
            }
        }

        if (best == null) {
            System.out.println("no slot for " + vehicle.getNumberPlate());
            return null;
        }

        best.occupy();
        counter++;
        Ticket t = new Ticket("TKT-" + counter, vehicle, best, entryTime);
        tickets.put(t.getTicketId(), t);
        return t;
    }

    public void status() {
        int smallFree = 0, medFree = 0, largeFree = 0;
        int smallTotal = 0, medTotal = 0, largeTotal = 0;

        for (int i = 0; i < slots.size(); i++) {
            ParkingSlot s = slots.get(i);
            if (s.getSlotType() == SlotType.SMALL) {
                smallTotal++;
                if (!s.isOccupied()) smallFree++;
            } else if (s.getSlotType() == SlotType.MEDIUM) {
                medTotal++;
                if (!s.isOccupied()) medFree++;
            } else {
                largeTotal++;
                if (!s.isOccupied()) largeFree++;
            }
        }

        System.out.println("SMALL: " + smallFree + "/" + smallTotal + " free");
        System.out.println("MEDIUM: " + medFree + "/" + medTotal + " free");
        System.out.println("LARGE: " + largeFree + "/" + largeTotal + " free");
    }

    public Bill exit(Ticket ticket, LocalDateTime exitTime) {
        Ticket t = tickets.get(ticket.getTicketId());
        if (t == null) {
            System.out.println("ticket not found");
            return null;
        }

        t.getSlot().free();
        tickets.remove(t.getTicketId());

        long hrs = ChronoUnit.HOURS.between(t.getEntryTime(), exitTime);
        if (hrs < 1) hrs = 1;

        double rate = rates.get(t.getSlot().getSlotType());
        double amt = hrs * rate;

        return new Bill(t, exitTime, hrs, amt);
    }
}
