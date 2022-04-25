package com.example.ReviewApp.userlogin;

public class AverageResponse {
    private double ambiance;
    private  double cleanliness;
    private  double drinks;
    private  double food;
    private  double service;
    private  double totalAverage;


    public AverageResponse(double ambiance, double cleanliness, double drinks, double food, double service, double totalAverage) {
        this.ambiance = ambiance;
        this.cleanliness = cleanliness;
        this.drinks = drinks;
        this.food = food;
        this.service = service;
        this.totalAverage = totalAverage;
    }

    public double getAmbiance() {
        return ambiance;
    }

    public void setAmbiance(double ambiance) {
        this.ambiance = ambiance;
    }

    public double getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(double cleanliness) {
        this.cleanliness = cleanliness;
    }

    public double getDrinks() {
        return drinks;
    }

    public void setDrinks(double drinks) {
        this.drinks = drinks;
    }

    public double getFood() {
        return food;
    }

    public void setFood(double food) {
        this.food = food;
    }

    public double getService() {
        return service;
    }

    public void setService(double service) {
        this.service = service;
    }

    public double getTotalAverage() {
        return totalAverage;
    }

    public void setTotalAverage(double totalAverage) {
        this.totalAverage = totalAverage;
    }
}
