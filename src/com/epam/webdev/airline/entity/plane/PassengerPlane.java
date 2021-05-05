package com.epam.webdev.airline.entity.plane;

import java.io.Serializable;

public class PassengerPlane extends AbstractPlane {
    private int passengerPlaces;

    public PassengerPlane() {}

    public PassengerPlane(double tankVolume, double fuelConsumptionRate, double maxSpeed, int crewSize, int passengerPlaces) {
        super(tankVolume, fuelConsumptionRate, maxSpeed, crewSize);
        this.passengerPlaces = passengerPlaces;
    }

    public int getPassengerPlaces() {
        return passengerPlaces;
    }

    public void setPassengerPlaces(int passengerPlaces) {
        this.passengerPlaces = passengerPlaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassengerPlane other = (PassengerPlane) o;

        if (!super.equals(o)) {
            return false;
        } else {
            return passengerPlaces == other.passengerPlaces;
        }
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + passengerPlaces;
        return result;
    }

    @Override
    public String toString() {
        return "PassengerPlane{" +
                "id=" + super.getId() +
                ", tankVolume=" + super.getTankVolume() +
                ", fuelConsumptionRate=" + super.getFuelConsumptionRate() +
                ", maxSpeed=" + super.getMaxSpeed() +
                ", crewSize=" + super.getCrewSize() +
                "passengerPlaces=" + passengerPlaces +
                '}';
    }
}
