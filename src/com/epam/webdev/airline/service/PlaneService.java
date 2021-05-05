package com.epam.webdev.airline.service;

import com.epam.webdev.airline.entity.plane.AbstractPlane;

import java.util.List;

public interface PlaneService {

    List<AbstractPlane> loadAll();

    AbstractPlane loadById(Long id);

    int save(AbstractPlane user);

    int update(AbstractPlane user);

    int delete(Long id);
}
