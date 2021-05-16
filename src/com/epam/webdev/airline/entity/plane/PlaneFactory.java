package com.epam.webdev.airline.entity.plane;

public class PlaneFactory {

    private static PlaneFactory instance;

    private PlaneFactory() {
    }

    public static synchronized PlaneFactory getInstance() {
        if(instance == null) {
            instance = new PlaneFactory();
        }
        return instance;
    }

    public AbstractPlane newPlane(PlaneType planeType) {
        return planeType.create();
    }
}
