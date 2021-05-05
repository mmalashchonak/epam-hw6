package com.epam.webdev.airline.entity.plane;

public class TransportPlane extends AbstractPlane {
    private double cargoCapacity;

    public TransportPlane() {}

    public TransportPlane(double tankVolume, double fuelConsumptionRate, double maxSpeed, int crewSize, double cargoCapacity) {
        super(tankVolume, fuelConsumptionRate, maxSpeed, crewSize);
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransportPlane)) return false;
        if (!super.equals(o)) return false;

        TransportPlane other = (TransportPlane) o;

        if (!super.equals(o)) {
            return false;
        } else {
            return Double.compare(other.cargoCapacity, cargoCapacity) == 0;
        }
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) cargoCapacity;
        return result;
    }

    @Override
    public String toString() {
        return "Freighter{" +
                "id=" + super.getId() +
                ", tankVolume=" + super.getTankVolume() +
                ", fuelConsumptionRate=" + super.getFuelConsumptionRate() +
                ", maxSpeed=" + super.getMaxSpeed() +
                ", crewSize=" + super.getCrewSize() +
                "cargoCapacity=" + cargoCapacity +
                '}';
    }
}
