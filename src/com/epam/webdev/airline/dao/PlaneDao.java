package com.epam.webdev.airline.dao;

import com.epam.webdev.airline.dao.exception.PlaneNotFoundException;
import com.epam.webdev.airline.dao.exception.PlaneSaveException;
import com.epam.webdev.airline.entity.plane.AbstractPlane;

import java.util.List;

public interface PlaneDao {

    List<AbstractPlane> loadAll() throws PlaneNotFoundException;

    AbstractPlane loadById(Long id) throws PlaneNotFoundException;

    boolean save(AbstractPlane plane) throws PlaneNotFoundException, PlaneSaveException;

    boolean update(AbstractPlane plane) throws PlaneSaveException;

    boolean delete(Long id) throws PlaneSaveException;
}

