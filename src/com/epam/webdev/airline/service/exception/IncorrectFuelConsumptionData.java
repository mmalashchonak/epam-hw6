package com.epam.webdev.airline.service.exception;

public class IncorrectFuelConsumptionData extends Exception{
    public IncorrectFuelConsumptionData() {
        super();
    }

    public IncorrectFuelConsumptionData(String message) {
        super(message);
    }

    public IncorrectFuelConsumptionData(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectFuelConsumptionData(Throwable cause) {
        super(cause);
    }
}
