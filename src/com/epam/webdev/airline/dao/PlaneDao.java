package com.epam.webdev.airline.dao;

import com.epam.webdev.airline.dao.exception.PlaneNotFoundException;
import com.epam.webdev.airline.dao.exception.PlaneSaveException;
import com.epam.webdev.airline.entity.plane.AbstractPlane;

import java.util.List;

public interface PlaneDao {

    List<AbstractPlane> loadAllPlanes() throws PlaneNotFoundException;

    boolean saveAllPlanes(List<AbstractPlane> planes) throws PlaneSaveException;

    AbstractPlane loadPlaneById(Long id) throws PlaneNotFoundException;

    boolean savePlane(AbstractPlane plane) throws PlaneNotFoundException, PlaneSaveException;

    boolean updatePlane(AbstractPlane plane) throws PlaneSaveException;

    boolean deletePlane(Long id) throws PlaneSaveException;
}

