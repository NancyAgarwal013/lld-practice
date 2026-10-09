package com.nancy.lld.parkinglot.model;

import com.nancy.lld.parkinglot.model.enums.VehicleType;

public class ParkingSlot {

    private final int parkingSlotId;
    private final VehicleType parkingSlotType;
    private Vehicle parkVehicle;

    public ParkingSlot(int parkingSlotId, VehicleType parkingSlotType) {
        //not taking parkVehicle in constructor, becoz we send
        // ParkingSlot bikeSpot =
        //        new ParkingSlot(1, VehicleType.BIKE);
        //
        //Vehicle bike =
        //        new Vehicle("KA01AB1234", VehicleType.BIKE);
        //
        //bikeSpot.parkVehicle(bike);
        this.parkingSlotId = parkingSlotId;
        this.parkingSlotType = parkingSlotType;
    }

    public int getParkingSlotId() {
        return parkingSlotId;
    }

    public VehicleType getParkingSlotType() {
        return parkingSlotType;
    }

    public Vehicle getParkedVehicle() {
        return parkVehicle;
    }

    public boolean isSlotAvailable() {
        return parkVehicle == null;
    }

    public void parkVehicle(Vehicle vehicle) {
        if(!isSlotAvailable()){
            System.out.println("Parking slot is already occupied.");
            return;
        }
        if(vehicle.getVehicleType() != this.parkingSlotType) { //basically what if bike wants to park in car's slot
            //System.out.println("Vehicle type is not compatible with this parking slot.");
            throw new IllegalStateException("Parking slot is already occupied");
        }
        this.parkVehicle = vehicle;
    }

    public void removeVehicle() {
       // this.parkingSlotType = null; // not add becoz if vehicle is removed but still parking slot would still be there
        this.parkVehicle = null;
    }
}
