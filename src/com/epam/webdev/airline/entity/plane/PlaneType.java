package com.epam.webdev.airline.entity.plane;

public enum PlaneType {
    PASSENGER {
        public AbstractPlane create() {
            return new PassengerPlane();
        }
    },
    TRANSPORT {
        public AbstractPlane create() {
            return new TransportPlane();
        }
    };

    public AbstractPlane create() {
        return null;
    }
}

