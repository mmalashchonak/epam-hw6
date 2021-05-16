package com.epam.webdev.airline.entity.plane;

import java.io.Serializable;

public class TransportPlane extends AbstractPlane implements Serializable {
    private double liftingCapacity;
    private double liftingVolume;

    public TransportPlane() {
    }

    public TransportPlane(double maxFlightDistance, double maxSpeed, double fuelConsumption, double liftingCapacity, double liftingVolume) {
        super(maxFlightDistance, maxSpeed, fuelConsumption);
        this.liftingCapacity = liftingCapacity;
        this.liftingVolume = liftingVolume;
    }

    public double getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(double liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }

    public double getLiftingVolume() {
        return liftingVolume;
    }

    public void setLiftingVolume(double liftingVolume) {
        this.liftingVolume = liftingVolume;
    }

    public boolean getLoadOnBoard(){
        // native method
        return true;
    }

    public boolean releaseLoadFromBoard(){
        // native method
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportPlane plane = (TransportPlane) o;
        if (!super.equals(o)) {
            return false;
        } else {
            return Double.compare(plane.liftingCapacity, liftingCapacity) == 0 &&
                    Double.compare(plane.liftingVolume, liftingVolume) == 0;
        }
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Double.hashCode(liftingCapacity);
        result = 31 * result + Double.hashCode(liftingVolume);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" +
                "id=" + super.getId() +
                ", maxFlightDistance=" + super.getMaxFlightDistance() +
                ", maxSpeed=" + super.getMaxSpeed() +
                ", fuelConsumption=" + super.getFuelConsumption() +
                ", liftingCapacity=" + liftingCapacity +
                ", liftingVolume=" + liftingVolume;
    }
}
