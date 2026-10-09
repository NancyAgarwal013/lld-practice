package com.nancy.lld.parkinglot.model;

import java.util.List;

public class ParkingLot {

    private final int parkingLotId;
    private final List<ParkingFloor> parkingFloors;

    public ParkingLot(int parkingLotId, List<ParkingFloor> parkingFloors) {
        this.parkingLotId = parkingLotId;
        this.parkingFloors = parkingFloors;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public ParkingSlot findAvailableSlot(Vehicle vehicle) {
        for (ParkingFloor floor : parkingFloors) {
            ParkingSlot slot = floor.findAvailableSlot(vehicle);
            if(slot != null) {
                return slot;
            }
        }
        return null;
    }
}
