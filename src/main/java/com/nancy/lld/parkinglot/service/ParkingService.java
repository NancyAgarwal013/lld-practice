package com.nancy.lld.parkinglot.service;

import com.nancy.lld.parkinglot.model.ParkingLot;
import com.nancy.lld.parkinglot.model.ParkingSlot;
import com.nancy.lld.parkinglot.model.ParkingTicket;
import com.nancy.lld.parkinglot.model.Vehicle;

import java.time.LocalDateTime;

public class ParkingService {

    private final ParkingLot parkingLot;
    private static int ticketCounter = 1;

    public ParkingService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {

        // 1. Find available slot
        ParkingSlot parkingSlot = parkingLot.findAvailableSlot(vehicle);

        // 2. If no slot exists, handle it
        if(parkingSlot == null) {
            throw new IllegalStateException(
                    "No parking slot available for "
                            + vehicle.getVehicleType()
            );
        }

        // 3. Park vehicle in that slot
        parkingSlot.parkVehicle(vehicle);

        // 4. Generate ticket
        ParkingTicket parkingTicket = new ParkingTicket(ticketCounter++,vehicle,parkingSlot, LocalDateTime.now());

        // 5. Return ticket
        return parkingTicket;
    }
}

/**
 *
 * Interview note: static int ticketCounter++ is not thread-safe, but don't solve that now.
 * If the interviewer asks about concurrency,
 * that's a great extension point (AtomicInteger, UUID, DB-generated ID, etc.).
 */
