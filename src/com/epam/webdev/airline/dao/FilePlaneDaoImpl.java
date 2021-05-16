package com.epam.webdev.airline.dao;

import com.epam.webdev.airline.dao.exception.PlaneNotFoundException;
import com.epam.webdev.airline.dao.exception.PlaneSaveException;
import com.epam.webdev.airline.entity.plane.AbstractPlane;
import com.epam.webdev.airline.source.file.FileDataBase;
import com.epam.webdev.airline.source.file.exception.FileLoadException;
import com.epam.webdev.airline.source.file.exception.FileSaveException;

import java.util.List;

public class FilePlaneDaoImpl implements PlaneDao {

    private final FileDataBase fileDataBase;

    public FilePlaneDaoImpl(FileDataBase fileDataBase) {
        this.fileDataBase = fileDataBase;
    }

    @Override
    public List<AbstractPlane> loadAllPlanes() throws PlaneNotFoundException {
        List<AbstractPlane> planes = null;
        try {
            planes = fileDataBase.loadAllPlanes();
        } catch (FileLoadException e) {
            throw new PlaneNotFoundException("Planes can not be written from file.", e);
        }
        return planes;
    }

    @Override
    public AbstractPlane loadPlaneById(Long id) throws PlaneNotFoundException {
        List<AbstractPlane> planes = loadAllPlanes();
        for (AbstractPlane plane : planes) {
            if (plane.getId().equals(id)) {
                return plane;
            }
        }

        return null;
    }

    @Override
    public boolean savePlane(AbstractPlane plane) throws PlaneSaveException {
        boolean addResult;
        boolean saveResult;
        try {
            List<AbstractPlane> planes = loadAllPlanes();
            addResult = planes.add(plane);
            saveResult = saveAllPlanes(planes);
        } catch (Exception e) {
            throw new PlaneSaveException("Plane save was not successful.", e);
        }

        return addResult && saveResult;
    }

    @Override
    public boolean updatePlane(AbstractPlane plane) throws PlaneSaveException {
        boolean removeResult;
        boolean addResult;
        try {
            List<AbstractPlane> planes = loadAllPlanes();
            removeResult = planes.remove(loadPlaneById(plane.getId()));
            addResult = planes.add(plane);
            saveAllPlanes(planes);
        } catch (Exception e) {
            throw new PlaneSaveException("Plane update was not successful.", e);
        }

        return addResult && removeResult;
    }

    @Override
    public boolean deletePlane(Long id) throws PlaneSaveException {
        boolean removeResult;
        boolean saveResult;
        try {
            List<AbstractPlane> planes = loadAllPlanes();
            removeResult = planes.removeIf(plane -> id.compareTo(plane.getId()) == 0);
            saveResult = saveAllPlanes(planes);
        } catch (Exception e) {
            throw new PlaneSaveException("Plane delete was not successful.", e);
        }

        return removeResult && saveResult;
    }

    @Override
    public boolean saveAllPlanes(List<AbstractPlane> planes) throws PlaneSaveException {
        try {
            fileDataBase.saveAllPlanes(planes);
        } catch (FileSaveException e) {
            throw new PlaneSaveException("Plane save was not successful.", e);
        }
        return true;
    }
}
