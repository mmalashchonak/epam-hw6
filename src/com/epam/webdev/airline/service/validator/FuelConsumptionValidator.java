package com.epam.webdev.airline.service.validator;

public class FuelConsumptionValidator {

    public static boolean checkIfFuelConsumptionValid(double fuelConsumption){
        boolean result = true;
        if(fuelConsumption <= 0){
            result = false;
        }
        return result;
    }

    public static boolean checkIfFuelConsumptionRangeValid(double minFuelConsumption, double maxFuelConsumption){
        boolean result = true;
        if(maxFuelConsumption <= minFuelConsumption){
            result = false;
        }
        return result;
    }
}
