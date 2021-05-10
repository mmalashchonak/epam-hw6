package com.epam.webdev.airline.dao;

import com.epam.webdev.airline.dao.exception.PlaneNotFoundException;
import com.epam.webdev.airline.dao.exception.PlaneSaveException;
import com.epam.webdev.airline.entity.plane.AbstractPlane;

import java.io.*;
import java.util.List;

public class FilePlaneDaoImpl implements PlaneDao {

    private String filePath;

    public FilePlaneDaoImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<AbstractPlane> loadAll() throws PlaneNotFoundException {
        List<AbstractPlane> planes;
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            planes = (List<AbstractPlane>) objectInputStream.readObject();
        } catch (Exception e) {
            throw new PlaneNotFoundException("Planes can not be written from file.", e);
        }
        return planes;
    }

    @Override
    public AbstractPlane loadById(Long id) throws PlaneNotFoundException {
        List<AbstractPlane> planes = loadAll();
        for (AbstractPlane plane : planes) {
            if (plane.getId().equals(id)) {
                return plane;
            }
        }

        return null;
    }

    @Override
    public boolean save(AbstractPlane plane) throws PlaneSaveException {
        boolean addResult;
        boolean saveResult;
        try {
            List<AbstractPlane> planes = loadAll();
            addResult = planes.add(plane);
            saveResult = saveAllPlanes(planes);
        } catch (Exception e) {
            throw new PlaneSaveException("Plane save was not successful.", e);
        }

        return addResult && saveResult;
    }

    @Override
    public boolean update(AbstractPlane plane) throws PlaneSaveException {
        boolean removeResult;
        boolean addResult;
        try {
            List<AbstractPlane> planes = loadAll();
            removeResult = planes.remove(loadById(plane.getId()));
            addResult = planes.add(plane);
            saveAllPlanes(planes);
        } catch (Exception e) {
            throw new PlaneSaveException("Plane update was not successful.", e);
        }

        return addResult && removeResult;
    }

    @Override
    public boolean delete(Long id) throws PlaneSaveException {
        boolean result;
        try {
            List<AbstractPlane> planes = loadAll();
            result = planes.remove(loadById(id));
        } catch (Exception e) {
            throw new PlaneSaveException("Plane delete was not successful.", e);
        }

        return result;
    }

    public boolean saveAllPlanes(List<AbstractPlane> planes) throws PlaneSaveException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(planes);
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new PlaneSaveException("Plane save was not successful.", e);
        }
        return true;
    }
}
