package com.epam.webdev.airline.util.comparator;

import com.epam.webdev.airline.entity.plane.AbstractPlane;

import java.util.Comparator;

    public class FuelConsumptionComparator implements Comparator<AbstractPlane> {
        @Override
        public int compare(AbstractPlane o1, AbstractPlane o2) {
            return Double.compare(o1.getFuelConsumption(), o2.getFuelConsumption());
        }
    }
