package com.epam.webdev.airline.service;

import com.epam.webdev.airline.entity.Airline;
import com.epam.webdev.airline.entity.plane.AbstractPlane;
import com.epam.webdev.airline.entity.plane.PassengerPlane;
import com.epam.webdev.airline.entity.plane.TransportPlane;
import com.epam.webdev.airline.service.exception.IncorrectFuelConsumptionData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AirlineProcessor {

    public static void SortPlanes(Airline airline, Comparator<AbstractPlane> comparator) {
        List<AbstractPlane> planes = airline.getPlanes();
        planes.sort(comparator);
    }

    public static double getTotalLiftingCapacity(Airline airline) {
        double result = 0;
        List<AbstractPlane> planes = airline.getPlanes();
        for (AbstractPlane plane : planes) {
            if (plane.getClass().equals(TransportPlane.class)) {
                TransportPlane transportPlane = (TransportPlane) plane;
                result += transportPlane.getLiftingCapacity();
            }
        }
        return result;
    }

    public static double getTotalPassengerCapacity(Airline airline) {
        double result = 0;
        List<AbstractPlane> planes = airline.getPlanes();
        for (AbstractPlane plane : planes) {
            if (plane.getClass().equals(PassengerPlane.class)) {
                PassengerPlane passengerPlane = (PassengerPlane) plane;
                result += passengerPlane.getPassengerCapacity();
            }
        }
        return result;
    }

    public static List<AbstractPlane> findPlaneByFuelConsumption(Airline airline, double minFuelConsumption, double maxFuelConsumption) throws IncorrectFuelConsumptionData {

        if(maxFuelConsumption <= 0 || minFuelConsumption <= 0){
            throw new IncorrectFuelConsumptionData("Input fuel consumption can not be negative or zero.");
        }

        if(maxFuelConsumption <= minFuelConsumption){
            throw new IncorrectFuelConsumptionData("Max fuel consumption value can not be lower or the same as min fuel consumption value.");
        }

        List<AbstractPlane> planes = airline.getPlanes();
        List<AbstractPlane> validPlanes = new ArrayList<>();
        for (AbstractPlane plane : planes) {
            if (plane.getFuelConsumption() >= minFuelConsumption && plane.getFuelConsumption() <= maxFuelConsumption) {
                validPlanes.add(plane);
            }
        }

        return validPlanes;
    }
}
