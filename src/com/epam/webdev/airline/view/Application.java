package com.epam.webdev.airline.view;

import com.epam.webdev.airline.entity.plane.*;
import com.epam.webdev.airline.service.PlaneService;
import com.epam.webdev.airline.service.ServiceFactory;
import com.epam.webdev.airline.service.ServiceType;
import com.epam.webdev.airline.service.exception.IncorrectFuelConsumptionData;
import com.epam.webdev.airline.service.exception.PlaneAddException;
import com.epam.webdev.airline.service.exception.PlaneGetException;
import com.epam.webdev.airline.util.comparator.DistanceAndSpeedComparator;
import com.epam.webdev.airline.util.comparator.FuelConsumptionComparator;

public class Application {
    public static void main(String[] args) {
        PlaneService airline = ServiceFactory.getInstance().newPlaneService(ServiceType.PLANE_SERVICE);

        PlaneFactory planeFactory = PlaneFactory.getInstance();
        PassengerPlane boing747 = (PassengerPlane) planeFactory.newPlane(PlaneType.PASSENGER);
        boing747.setId(0L);
        boing747.setFuelConsumption(10);
        boing747.setMaxFlightDistance(1000);
        boing747.setMaxSpeed(1200);
        boing747.setPassengerCapacity(250);
        boing747.setPlaneClass(PlaneClass.COMFORT);
        boing747.setLuggageWeight(1500);

        PassengerPlane su1000 = (PassengerPlane) planeFactory.newPlane(PlaneType.PASSENGER);
        su1000.setId(1L);
        su1000.setFuelConsumption(12);
        su1000.setMaxFlightDistance(900);
        su1000.setMaxSpeed(1100);
        su1000.setPassengerCapacity(190);
        su1000.setPlaneClass(PlaneClass.VIP);
        su1000.setLuggageWeight(2000);

        TransportPlane an124 = (TransportPlane) planeFactory.newPlane(PlaneType.TRANSPORT);
        an124.setId(2L);
        an124.setFuelConsumption(15);
        an124.setMaxFlightDistance(900);
        an124.setMaxSpeed(1100);
        an124.setLiftingCapacity(2500);
        an124.setLiftingVolume(1800);

        TransportPlane an225 = (TransportPlane) planeFactory.newPlane(PlaneType.TRANSPORT);
        an225.setId(3L);
        an225.setFuelConsumption(20);
        an225.setMaxFlightDistance(900);
        an225.setMaxSpeed(1100);
        an225.setLiftingCapacity(3500);
        an225.setLiftingVolume(2200);

        try {
            airline.addPlane(boing747);
            airline.addPlane(su1000);
            airline.addPlane(an124);
            airline.addPlane(an225);
        } catch (PlaneAddException e) {
            // обработка исключения
            e.printStackTrace();
        }


        try {
            System.out.println("Unsorted planes: " + airline.getPlanes().toString());
        } catch (PlaneGetException e) {
            // обработка исключения
            e.printStackTrace();
        }

        try {
            airline.SortPlanes(new FuelConsumptionComparator());
        } catch (PlaneGetException | PlaneAddException e) {
            // обработка исключения
            e.printStackTrace();
        }

        try {
            System.out.println("Planes sorted by fuel consumption: " + airline.getPlanes().toString());
        } catch (PlaneGetException e) {
            // обработка исключения
            e.printStackTrace();
        }

        try {
            airline.SortPlanes(new DistanceAndSpeedComparator());
        } catch (PlaneGetException | PlaneAddException e) {
            // обработка исключения
            e.printStackTrace();
        }

        try {
            System.out.println("Planes sorted by max distance and speed: " + airline.getPlanes().toString());
        } catch (PlaneGetException e) {
            // обработка исключения
            e.printStackTrace();
        }

        try {
            System.out.println("Total lifting capacity: " + airline.calculateTotalLiftingCapacity());
        } catch (PlaneGetException e) {
            // обработка исключения
            e.printStackTrace();
        }

        try {
            System.out.println("Total passengers capacity: " + airline.calculateTotalPassengerCapacity());
        } catch (PlaneGetException e) {
            // обработка исключения
            e.printStackTrace();
        }


        try {
            System.out.println("Planes with fuel consumption from 12 to 17: "
                    + airline.findPlaneByFuelConsumption(12, 17));
        } catch (IncorrectFuelConsumptionData incorrectFuelConsumptionData) {
            // обработка исключения
            incorrectFuelConsumptionData.printStackTrace();
        } catch (PlaneGetException e) {
            // обработка исключения
            e.printStackTrace();
        }


        try {
            airline.removePlane(boing747.getId());
            airline.removePlane(an124.getId());
            airline.removePlane(an225.getId());
            airline.removePlane(su1000.getId());
        } catch (PlaneAddException e) {
            e.printStackTrace();
        }
    }
}
