package com.epam.webdev.airline.dao;

public class DAOFactory {

    private static DAOFactory instance;

    private DAOFactory() {
    }

    public static synchronized DAOFactory getInstance() {
        if(instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public PlaneDao newPlaneDao(PlaneDaoType planeDaoType) {
        return planeDaoType.create();
    }
}
