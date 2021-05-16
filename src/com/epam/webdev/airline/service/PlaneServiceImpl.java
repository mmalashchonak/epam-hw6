package com.epam.webdev.airline.service;

import com.epam.webdev.airline.dao.PlaneDao;
import com.epam.webdev.airline.dao.exception.PlaneNotFoundException;
import com.epam.webdev.airline.dao.exception.PlaneSaveException;
import com.epam.webdev.airline.entity.plane.AbstractPlane;
import com.epam.webdev.airline.entity.plane.PassengerPlane;
import com.epam.webdev.airline.entity.plane.TransportPlane;
import com.epam.webdev.airline.service.exception.IncorrectFuelConsumptionData;
import com.epam.webdev.airline.service.exception.PlaneAddException;
import com.epam.webdev.airline.service.exception.PlaneGetException;
import com.epam.webdev.airline.service.validator.FuelConsumptionValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PlaneServiceImpl implements PlaneService {
    private PlaneDao planeDao;

    public PlaneServiceImpl(PlaneDao planeDao) {
        this.planeDao = planeDao;
    }

    public List<AbstractPlane> getPlanes() throws PlaneGetException {
        try {
            return planeDao.loadAllPlanes();
        } catch (PlaneNotFoundException e) {
            throw new PlaneGetException("Plane loading was failed.", e);
        }
    }

    public boolean addPlane(AbstractPlane plane) throws PlaneAddException {
        boolean daoResult = false;
        try {
            daoResult = planeDao.savePlane(plane);
        } catch (PlaneNotFoundException | PlaneSaveException e){
            throw new PlaneAddException("Plane adding was failed.");
        }
        return daoResult;
    }

    @Override
    public boolean removePlane(Long id) throws PlaneAddException {
        boolean daoResult = false;
        try {
            daoResult = planeDao.deletePlane(id);
        } catch (PlaneSaveException e) {
            throw new PlaneAddException("Plane deleting was failed due to error while saving of final operation result.");
        }
        return daoResult;
    }

    @Override
    public void SortPlanes(Comparator<AbstractPlane> comparator) throws PlaneGetException, PlaneAddException {
        Optional<List<AbstractPlane>> planes;
        try {
            planes = Optional.of(planeDao.loadAllPlanes());
        } catch (PlaneNotFoundException e) {
            throw new PlaneGetException("Plane loading was failed.", e);
        }

        planes.orElse(new ArrayList<>()).sort(comparator);
        try {
            planeDao.saveAllPlanes(planes.get());
        } catch (PlaneSaveException e) {
            throw new PlaneAddException("Plane sorting was failed due to error while saving of final operation result.");
        }
    }

    @Override
    public double calculateTotalLiftingCapacity() throws PlaneGetException {
        double result = 0;
        Optional<List<AbstractPlane>> planes;
        try {
            planes = Optional.of(planeDao.loadAllPlanes());
        } catch (PlaneNotFoundException e) {
            throw new PlaneGetException("Plane loading was failed.", e);
        }

        for (AbstractPlane plane : planes.orElse(new ArrayList<>())) {
            if (plane.getClass().equals(TransportPlane.class)) {
                TransportPlane transportPlane = (TransportPlane) plane;
                result += transportPlane.getLiftingCapacity();
            }
        }
        return result;
    }

    @Override
    public double calculateTotalPassengerCapacity() throws PlaneGetException {
        double result = 0;
        Optional<List<AbstractPlane>> planes;
        try {
            planes = Optional.of(planeDao.loadAllPlanes());
        } catch (PlaneNotFoundException e) {
            throw new PlaneGetException("Plane loading was failed.", e);
        }

        for (AbstractPlane plane : planes.orElse(new ArrayList<>())) {
            if (plane.getClass().equals(PassengerPlane.class)) {
                PassengerPlane passengerPlane = (PassengerPlane) plane;
                result += passengerPlane.getPassengerCapacity();
            }
        }
        return result;
    }

    @Override
    public List<AbstractPlane> findPlaneByFuelConsumption(double minFuelConsumption, double maxFuelConsumption)
            throws IncorrectFuelConsumptionData, PlaneGetException {

        if (!FuelConsumptionValidator.checkIfFuelConsumptionValid(maxFuelConsumption)
                || !FuelConsumptionValidator.checkIfFuelConsumptionValid(minFuelConsumption)) {
            throw new IncorrectFuelConsumptionData("Input fuel consumption can not be negative or zero.");
        }

        if (!FuelConsumptionValidator.checkIfFuelConsumptionRangeValid(minFuelConsumption, maxFuelConsumption)) {
            throw new IncorrectFuelConsumptionData("Max fuel consumption value can not be lower or the same as min fuel consumption value.");
        }

        Optional<List<AbstractPlane>> planes;
        try {
            planes = Optional.of(planeDao.loadAllPlanes());
        } catch (PlaneNotFoundException e) {
            throw new PlaneGetException("Plane loading was failed.", e);
        }

        List<AbstractPlane> validPlanes = new ArrayList<>();
        for (AbstractPlane plane : planes.orElse(new ArrayList<>())) {
            if (plane.getFuelConsumption() >= minFuelConsumption && plane.getFuelConsumption() <= maxFuelConsumption) {
                validPlanes.add(plane);
            }
        }

        return validPlanes;
    }
}

