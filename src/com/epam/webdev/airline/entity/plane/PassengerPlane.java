package com.epam.webdev.airline.entity.plane;

import java.io.Serializable;

public class PassengerPlane extends AbstractPlane implements Serializable {
    private int passengerCapacity;

    public PassengerPlane() {}

    public PassengerPlane(double maxFlightDistance, double maxSpeed, double fuelConsumption, int passengerCapacity) {
        super(maxFlightDistance, maxSpeed, fuelConsumption);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void getPassengersOnBoat(){

    }

    public void getPassengersOnBoard(){

    }

    public void releasePassengersFromBoard(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerPlane plane = (PassengerPlane) o;
        if (!super.equals(o)) {
            return false;
        } else {
            return Integer.compare(passengerCapacity, plane.passengerCapacity) == 0;
        }
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + passengerCapacity;
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" +
                "id=" + super.getId() +
                ", maxFlightDistance=" + super.getMaxFlightDistance() +
                ", maxSpeed=" + super.getMaxSpeed() +
                ", fuelConsumption=" + super.getFuelConsumption() +
                ", passengerCapacity=" + passengerCapacity;
    }
}
