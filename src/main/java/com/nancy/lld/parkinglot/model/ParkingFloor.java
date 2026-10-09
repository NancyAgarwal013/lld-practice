package com.nancy.lld.parkinglot.model;

import java.util.List;

public class ParkingFloor {

    private final int parkingFloorId;
    private final List<ParkingSlot> parkingSlots;
//    private List<Vehicle> vehicles; // not needed we can get this from parkingSlot -> Vehicle
//    int capacity; -> parkingslot.size()


    public ParkingFloor(int parkingFloorId, List<ParkingSlot> parkingSlots) {
        this.parkingFloorId = parkingFloorId;
        this.parkingSlots = parkingSlots;
    }

    public int getParkingFloorId() {
        return parkingFloorId;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public int getAvailableSlotCount() {
        int count = 0;
       for (ParkingSlot parkingSlot : parkingSlots) {
           if (parkingSlot.isSlotAvailable()) {
               count++;
           }
       }
       return count;
    }

    public ParkingSlot findAvailableSlot(Vehicle vehicle) {
        for(ParkingSlot slot : parkingSlots) {
            if((slot.getParkingSlotType() == vehicle.getVehicleType()) && slot.isSlotAvailable()) {
                return slot;
            }
        }
        return null;
    }
}
