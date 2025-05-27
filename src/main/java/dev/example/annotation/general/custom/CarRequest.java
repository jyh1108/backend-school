package dev.example.annotation.general.custom;

import dev.example.annotation.general.custom.annotation.YearRange;

public class CarRequest {
    private final String model;
    @YearRange(min = 2000, max = 2025)
    private final Integer year;
    public CarRequest(String model, Integer year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }
}
