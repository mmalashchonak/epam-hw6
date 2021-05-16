package com.epam.webdev.airline.service;

import com.epam.webdev.airline.dao.DAOFactory;
import com.epam.webdev.airline.dao.PlaneDaoType;

public enum ServiceType {

    PLANE_SERVICE {
        public PlaneService create() {
            return new PlaneServiceImpl(DAOFactory.getInstance().newPlaneDao(PlaneDaoType.FILE_PLANE_DAO));
        }
    };

    public PlaneService create() {
        return null;
    }
}