package com.pinappchallenge.app.rest.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Client kpi Response DTO")
public class ClientKpiResDTO {
    private double averageAge;
    private double standardDeviation;

    // Constructor
    public ClientKpiResDTO(double averageAge, double standardDeviation) {
        this.averageAge = averageAge;
        this.standardDeviation = standardDeviation;
    }

    // Getters y setters

    public double getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(double averageAge) {
        this.averageAge = averageAge;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }
}
