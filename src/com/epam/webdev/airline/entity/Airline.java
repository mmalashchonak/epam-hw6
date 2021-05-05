package com.epam.webdev.airline.entity;

import com.epam.webdev.airline.entity.plane.AbstractPlane;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Airline implements Serializable {
    List<AbstractPlane> planes = new ArrayList<>();

    public Airline() {
    }

    public Airline(List<AbstractPlane> planes) {
        if (planes != null) {
            this.planes = new ArrayList<>(planes);
        }
    }

    public List<AbstractPlane> getPlanes() {
        return planes;
    }

    public void addPlane(AbstractPlane plane) {
        planes.add(plane);
    }

    public void removePlane(AbstractPlane plane) {
        planes.remove(plane);
    }

    public void removePlane(int planeID) {
        planes.removeIf((plane) -> plane.getId() == planeID);
    }
}
