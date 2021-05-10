package com.epam.webdev.airline.util.comparator;

import com.epam.webdev.airline.entity.plane.AbstractPlane;

import java.util.Comparator;

public class DistanceAndSpeedComparator implements Comparator<AbstractPlane> {

    @Override
    public int compare(AbstractPlane o1, AbstractPlane o2) {
        if (Double.compare(o1.getMaxSpeed(), o2.getMaxSpeed()) != 0) {
            return Double.compare(o1.getMaxSpeed(), o2.getMaxSpeed());
        } else {
            return Double.compare(o1.getMaxFlightDistance(), o2.getMaxFlightDistance());
        }
    }
}
