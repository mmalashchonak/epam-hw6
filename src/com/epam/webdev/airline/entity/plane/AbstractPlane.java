package com.epam.webdev.airline.entity.plane;

import java.io.Serializable;

public abstract class AbstractPlane  implements Serializable {
    private Long id;
    private double maxFlightDistance;
    private double maxSpeed;
    private double fuelConsumption;

    AbstractPlane() {}

    public AbstractPlane(double maxFlightDistance, double maxSpeed, double fuelConsumption) {
        this.maxFlightDistance = maxFlightDistance;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public void setMaxFlightDistance(double maxFlightDistance) {
        this.maxFlightDistance = maxFlightDistance;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public boolean fly(){
        // native method
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPlane plane = (AbstractPlane) o;
        return Long.compare(plane.id, id) == 0 &&
        Double.compare(plane.maxFlightDistance, maxFlightDistance) == 0 &&
        Double.compare(plane.fuelConsumption, fuelConsumption) == 0 &&
        Double.compare(plane.maxSpeed, maxSpeed) != 0;
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + Double.hashCode(maxFlightDistance);
        result = 31 * result + Double.hashCode(maxSpeed);
        result = 31 * result + Double.hashCode(fuelConsumption);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" +
                "id=" + id +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxSpeed=" + maxSpeed +
                ", fuelConsumption=" + fuelConsumption;
    }
}
