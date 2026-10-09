package com.nancy.lld.parkinglot.model;

import com.nancy.lld.parkinglot.model.enums.VehicleType;

public class Vehicle {

    private final String registrationNumber;
    private final VehicleType vehicleType;

    public Vehicle(String registrationNumber, VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}

/**
 * "The registration number and vehicle type represent properties that shouldn't change during the lifetime of this Vehicle object,
 * so I made them immutable. That also prevents invalid state changes."
 *
 */
