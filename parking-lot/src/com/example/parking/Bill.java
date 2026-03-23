package com.example.parking;

import java.time.LocalDateTime;

public class Bill {
    Ticket ticket;
    LocalDateTime exitTime;
    long hours;
    double totalAmount;

    public Bill(Ticket ticket, LocalDateTime exitTime, long hours, double totalAmount) {
        this.ticket = ticket;
        this.exitTime = exitTime;
        this.hours = hours;
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount() { return totalAmount; }

    public void printBill() {
        System.out.println(ticket.getTicketId() + " | " + ticket.getVehicle().getNumberPlate() + " | " + hours + "hrs | Rs " + totalAmount);
    }
}
