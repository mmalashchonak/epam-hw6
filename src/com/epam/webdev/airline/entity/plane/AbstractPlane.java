package com.epam.webdev.airline.entity.plane;

import java.io.Serializable;

public abstract class AbstractPlane  implements Serializable {
    private Long id;
    private double tankVolume;
    private double fuelConsumptionRate;
    private double maxSpeed;
    private int crewSize;

    AbstractPlane() {}

    public AbstractPlane(double tankVolume, double fuelConsumptionRate, double maxSpeed, int crewSize) {
        this.tankVolume = tankVolume;
        this.fuelConsumptionRate = fuelConsumptionRate;
        this.maxSpeed = maxSpeed;
        this.crewSize = crewSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(double tankVolume) {
        this.tankVolume = tankVolume;
    }

    public double getFuelConsumptionRate() {
        return fuelConsumptionRate;
    }

    public void setFuelConsumptionRate(double fuelConsumptionRate) {
        this.fuelConsumptionRate = fuelConsumptionRate;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(int crewSize) {
        this.crewSize = crewSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractPlane that = (AbstractPlane) o;

        if (id != that.id) return false;
        if (Double.compare(that.tankVolume, tankVolume) != 0) return false;
        if (Double.compare(that.fuelConsumptionRate, fuelConsumptionRate) != 0) return false;
        if (Double.compare(that.maxSpeed, maxSpeed) != 0) return false;
        return crewSize == that.crewSize;
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + (int) tankVolume;
        result = 31 * result + (int) fuelConsumptionRate;
        result = 31 * result + (int) maxSpeed;
        result = 31 * result + crewSize;
        return result;
    }

    @Override
    public String toString() {
        return "AbstractPlane{" +
                "id=" + id +
                ", tankVolume=" + tankVolume +
                ", fuelConsumptionRate=" + fuelConsumptionRate +
                ", maxSpeed=" + maxSpeed +
                ", crewSize=" + crewSize +
                '}';
    }
}
