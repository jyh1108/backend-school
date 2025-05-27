package dev.example.annotation.general.custom;

import dev.example.annotation.general.custom.annotation.ModelDescriptionPrint;
import dev.example.annotation.general.custom.annotation.ModelDescriptionPrints;

import java.time.LocalDate;


public class Car {
    private final String model;
    private final Integer year;

    public Car(String model, Integer year) {
        this.model = model;
        this.year = year;
    }

    @ModelDescriptionPrints({
            @ModelDescriptionPrint(model = "Sonata", description = "steady seller"),
            @ModelDescriptionPrint(model = "Ionic", description = "new model"),
            @ModelDescriptionPrint(model = "Grandeur", description = "luxury model"),
            @ModelDescriptionPrint(model = "Avante", description = "compact model"),
            @ModelDescriptionPrint(model = "Morning", description = "small car")
    })
    public String getModel() {
        try {
            ModelDescriptionPrint[] annotations = this.getClass().getMethod("getModel").getAnnotationsByType(ModelDescriptionPrint.class);
            for (ModelDescriptionPrint annotation : annotations) {
                if (annotation.model().equals(model)) {
                    System.out.println(annotation.description());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return model;
    }

    public Integer getYear() {
        return year;
    }

    private boolean isNeedMaintenance() {
        return LocalDate.of(year, 1, 1).isBefore(LocalDate.now().minusYears(5));
    }

    public boolean isNeedChangeOil() {
        return LocalDate.of(year, 1, 1).isBefore(LocalDate.now().minusYears(1));
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
