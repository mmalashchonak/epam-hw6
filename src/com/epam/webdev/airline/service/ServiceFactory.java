package com.epam.webdev.airline.service;

public class ServiceFactory {
    private static ServiceFactory instance;

    private ServiceFactory() {
    }

    public static synchronized ServiceFactory getInstance() {
        if(instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }

    public PlaneService newPlaneService(ServiceType planeServiceType) {
        return planeServiceType.create();
    }
}
