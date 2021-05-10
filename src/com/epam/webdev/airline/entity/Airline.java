package com.epam.webdev.airline.entity;

import com.epam.webdev.airline.dao.FilePlaneDaoImpl;
import com.epam.webdev.airline.dao.PlaneDao;
import com.epam.webdev.airline.dao.exception.PlaneNotFoundException;
import com.epam.webdev.airline.dao.exception.PlaneSaveException;
import com.epam.webdev.airline.entity.plane.AbstractPlane;

import java.io.Serializable;

import java.util.List;

public class Airline implements Serializable {
    private PlaneDao planeDao;
    private List<AbstractPlane> planes;

    public Airline() throws PlaneNotFoundException {
        this.planeDao = new FilePlaneDaoImpl("planes.txt");
        this.planes = planeDao.loadAll();
    }

    public Airline(PlaneDao planeDao) throws PlaneNotFoundException {
        this.planeDao = planeDao;
        this.planes = planeDao.loadAll();
    }

    public List<AbstractPlane> getPlanes() {
        return planes;
    }

    public boolean addPlane(AbstractPlane plane) throws PlaneSaveException, PlaneNotFoundException {
        boolean listResult = planes.add(plane);
        boolean daoResult = planeDao.save(plane);
        return listResult && daoResult;
    }

    public boolean removePlane(Long id) throws PlaneSaveException {
        boolean listResult = planes.removeIf(plane -> id.compareTo(plane.getId()) == 0);
        boolean daoResult = planeDao.delete(id);
        return listResult && daoResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(getClass() == o.getClass())) return false;
        Airline airline = (Airline) o;
        return getPlanes().equals(airline.getPlanes());

    }

    @Override
    public int hashCode() {
        if (getPlanes() == null)
            return 0;

        int result = 1;

        for (AbstractPlane plane : getPlanes())
            result = 31 * result + (plane == null ? 0 : plane.hashCode());

        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" +
                "planes=" + planes;
    }
}
