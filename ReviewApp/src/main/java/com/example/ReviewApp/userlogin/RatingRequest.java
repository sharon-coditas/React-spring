package com.example.ReviewApp.userlogin;

import javax.validation.constraints.NotBlank;


public class RatingRequest {

    @NotBlank
    private int ambiance;
    @NotBlank
    private int food;
    @NotBlank
    private  int service;
    @NotBlank
    private int cleanliness;
    @NotBlank
    private  int drinks ;

    public int getAmbiance() {
        return ambiance;
    }

    public void setAmbiance(int ambiance) {
        this.ambiance = ambiance;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }

    public int getDrinks() {
        return drinks;
    }

    public void setDrinks(int drinks) {
        this.drinks = drinks;
    }
}
