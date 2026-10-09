package com.nancy.lld.parkinglot.service;

import com.nancy.lld.parkinglot.model.ParkingTicket;

import java.time.Duration;
import java.time.LocalDateTime;

public class FeeCalculator {

    private double calculateFee(ParkingTicket parkingTicket) {
        long hours = Duration.between(parkingTicket.getEntryTime(), LocalDateTime.now()).toHours();
        hours = Math.max(hours, 1);
        return 0;
    }
}
