package com.epam.webdev.airline.entity.plane;

import java.io.Serializable;

public class PassengerPlane extends AbstractPlane implements Serializable {
    private int passengerCapacity;
    private PlaneClass planeClass;
    private double luggageWeight;

    public PassengerPlane() {
    }

    public PassengerPlane(double maxFlightDistance, double maxSpeed, double fuelConsumption, int passengerCapacity, PlaneClass planeClass, double luggageWeight) {
        super(maxFlightDistance, maxSpeed, fuelConsumption);
        this.passengerCapacity = passengerCapacity;
        this.planeClass = planeClass;
        this.luggageWeight = luggageWeight;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public PlaneClass getPlaneClass() {
        return planeClass;
    }

    public void setPlaneClass(PlaneClass planeClass) {
        this.planeClass = planeClass;
    }

    public double getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }


    public boolean getPassengersOnBoard() {
        // native method
        return true;
    }

    public boolean releasePassengersFromBoard() {
        // native method
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerPlane plane = (PassengerPlane) o;
        if (!super.equals(o)) {
            return false;
        } else {
            return Integer.compare(passengerCapacity, plane.passengerCapacity) == 0 &&
                    planeClass == plane.planeClass &&
                    Double.compare(luggageWeight, plane.luggageWeight) == 0;
        }
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + passengerCapacity;
        result = 31 * result + planeClass.hashCode();
        result = 31 * result + Double.hashCode(luggageWeight);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" +
                "id=" + super.getId() +
                ", maxFlightDistance=" + super.getMaxFlightDistance() +
                ", maxSpeed=" + super.getMaxSpeed() +
                ", fuelConsumption=" + super.getFuelConsumption() +
                ", passengerCapacity=" + passengerCapacity +
                ", planeClass=" + planeClass +
                ", luggageWeight=" + luggageWeight;
    }
}
