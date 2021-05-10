package com.epam.webdev.airline.entity.plane;

public class PlaneFactory {

    public AbstractPlane newInstance(PlaneType planeType) {
        return planeType.create();
    }
}
