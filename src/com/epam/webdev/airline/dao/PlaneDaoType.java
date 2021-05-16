package com.epam.webdev.airline.dao;

import com.epam.webdev.airline.source.file.FileDataBase;

public enum PlaneDaoType {

    FILE_PLANE_DAO {
        public PlaneDao create() {
            return new FilePlaneDaoImpl(FileDataBase.getInstance());
        }
    };

    public PlaneDao create() {
        return null;
    }
}
