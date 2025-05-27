package dev.example.annotation.general.custom;

import dev.example.annotation.general.custom.validator.Validator;

public class CarFactory {
    public static Car createCar(CarRequest carRequest) {
        Validator.validateYear(carRequest);
        return new Car(carRequest.getModel(), carRequest.getYear());
    }
}
