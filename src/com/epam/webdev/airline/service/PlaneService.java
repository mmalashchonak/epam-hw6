package com.epam.webdev.airline.service;

import com.epam.webdev.airline.entity.plane.AbstractPlane;
import com.epam.webdev.airline.service.exception.IncorrectFuelConsumptionData;
import com.epam.webdev.airline.service.exception.PlaneAddException;
import com.epam.webdev.airline.service.exception.PlaneGetException;

import java.util.Comparator;
import java.util.List;

public interface PlaneService {

    List<AbstractPlane> getPlanes() throws PlaneGetException;

    boolean addPlane(AbstractPlane plane) throws PlaneAddException;

    boolean removePlane(Long id) throws PlaneAddException;

    void SortPlanes(Comparator<AbstractPlane> comparator) throws PlaneGetException, PlaneAddException;

    double calculateTotalLiftingCapacity() throws PlaneGetException;

    double calculateTotalPassengerCapacity() throws PlaneGetException;

    List<AbstractPlane> findPlaneByFuelConsumption(double minFuelConsumption, double maxFuelConsumption)
            throws IncorrectFuelConsumptionData, PlaneGetException;
}
