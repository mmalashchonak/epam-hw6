package com.epam.webdev.airline;

import com.epam.webdev.airline.dao.FilePlaneDaoImpl;
import com.epam.webdev.airline.dao.PlaneDao;
import com.epam.webdev.airline.dao.exception.PlaneNotFoundException;
import com.epam.webdev.airline.dao.exception.PlaneSaveException;
import com.epam.webdev.airline.entity.Airline;
import com.epam.webdev.airline.entity.plane.*;
import com.epam.webdev.airline.service.AirlineProcessor;
import com.epam.webdev.airline.service.exception.IncorrectFuelConsumptionData;
import com.epam.webdev.airline.util.comparator.DistanceAndSpeedComparator;
import com.epam.webdev.airline.util.comparator.FuelConsumptionComparator;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws PlaneSaveException, PlaneNotFoundException, IncorrectFuelConsumptionData {
        PlaneDao planeDao = new FilePlaneDaoImpl("planes.txt");
        Airline airline = new Airline(planeDao);

        PlaneFactory planeFactory = new PlaneFactory();
        PassengerPlane boing747 = (PassengerPlane) planeFactory.newInstance(PlaneType.PASSENGER);
        boing747.setId(0L);
        boing747.setFuelConsumption(10);
        boing747.setMaxFlightDistance(1000);
        boing747.setMaxSpeed(1200);
        boing747.setPassengerCapacity(250);

        PassengerPlane su1000 = (PassengerPlane) planeFactory.newInstance(PlaneType.PASSENGER);
        su1000.setId(1L);
        su1000.setFuelConsumption(12);
        su1000.setMaxFlightDistance(900);
        su1000.setMaxSpeed(1100);
        su1000.setPassengerCapacity(190);

        TransportPlane an124 = (TransportPlane) planeFactory.newInstance(PlaneType.TRANSPORT);
        an124.setId(2L);
        an124.setFuelConsumption(15);
        an124.setMaxFlightDistance(900);
        an124.setMaxSpeed(1100);
        an124.setLiftingCapacity(2500);

        TransportPlane an225 = (TransportPlane) planeFactory.newInstance(PlaneType.TRANSPORT);
        an225.setId(3L);
        an225.setFuelConsumption(20);
        an225.setMaxFlightDistance(900);
        an225.setMaxSpeed(1100);
        an225.setLiftingCapacity(3500);

        airline.addPlane(boing747);
        airline.addPlane(su1000);
        airline.addPlane(an124);
        airline.addPlane(an225);

        System.out.println("Unsorted planes: " + airline.toString());

        AirlineProcessor.SortPlanes(airline, new FuelConsumptionComparator());

        System.out.println("Planes sorted by fuel consumption: " + airline.toString());

        AirlineProcessor.SortPlanes(airline, new DistanceAndSpeedComparator());

        System.out.println("Planes sorted by max distance and speed: " + airline.toString());

        System.out.println("Total lifting capacity: " + AirlineProcessor.getTotalLiftingCapacity(airline));

        System.out.println("Total passengers capacity: " + AirlineProcessor.getTotalPassengerCapacity(airline));

        System.out.println("Planes with fuel consumption from 12 to 17: " + AirlineProcessor.findPlaneByFuelConsumption(airline, 12, 17));

        airline.removePlane(boing747.getId());
        airline.removePlane(an124.getId());
        airline.removePlane(an225.getId());
        airline.removePlane(su1000.getId());
    }
}
