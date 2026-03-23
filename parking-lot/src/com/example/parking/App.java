package com.example.parking;

import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();

        lot.addSlot(new ParkingSlot(1, SlotType.SMALL, 0, 1));
        lot.addSlot(new ParkingSlot(2, SlotType.SMALL, 0, 2));
        lot.addSlot(new ParkingSlot(3, SlotType.MEDIUM, 0, 3));
        lot.addSlot(new ParkingSlot(4, SlotType.MEDIUM, 0, 4));
        lot.addSlot(new ParkingSlot(5, SlotType.LARGE, 0, 5));
        lot.addSlot(new ParkingSlot(6, SlotType.SMALL, 1, 6));
        lot.addSlot(new ParkingSlot(7, SlotType.MEDIUM, 1, 7));
        lot.addSlot(new ParkingSlot(8, SlotType.LARGE, 1, 8));

        EntryGate g1 = new EntryGate(1);
        EntryGate g2 = new EntryGate(3);

        System.out.println("--- Parking ---");
        Vehicle bike = new Vehicle("KA01-1234", VehicleType.TWO_WHEELER);
        Ticket t1 = lot.park(bike, g1);
        t1.printTicket();

        Vehicle car = new Vehicle("KA02-5678", VehicleType.CAR);
        Ticket t2 = lot.park(car, g2);
        t2.printTicket();

        Vehicle bus = new Vehicle("KA03-9999", VehicleType.BUS);
        Ticket t3 = lot.park(bus, g1);
        t3.printTicket();

        System.out.println("\n--- Exit & Billing ---");
        lot.exit(t1.getTicketId(), LocalDateTime.now().plusHours(3)).printBill();
        lot.exit(t2.getTicketId(), LocalDateTime.now().plusHours(5)).printBill();
        lot.exit(t3.getTicketId(), LocalDateTime.now().plusHours(2)).printBill();
    }
}
